package com.metacube.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.assignment.database.ConnectionClass;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Inventory;

/**
 * This class implements the methods of the BaseDao Interface to perform operations on the database.
 * @author Jugal
 * Dated 09/04/2019
 */
public class SQLDAO implements BaseDao<Inventory> {

	private Connection connection;
	
	public SQLDAO() throws ClassNotFoundException, SQLException {
		connection = ConnectionClass.makeConnection();
	}
	
	@Override
	public List<Inventory> getList(String query) {
		List<Inventory> inventoryList = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while (resultSet.next()) {
				inventoryList.add(new Inventory(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return inventoryList;
	}

	@Override
	public Status insertItemToInventory(String query) {
		Status status;
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(statement.executeUpdate() > 0)
			{
				connection.commit();
				status = Status.INSERTED;
			}
			else
			{
				status = Status.INVALID;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			status = Status.ERROR;
		}
		return status;
	}

	@Override
	public Status performUpdate(String query) {
		Status status;
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(statement.executeUpdate() > 0)
			{
				connection.commit();
				status = Status.UPDATED;
			}
			else
			{
				status = Status.INVALID;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			status = Status.ERROR;
		}
		return status;
	}

	@Override
	public Inventory getAnItemFromInventory(String query) {
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new Inventory(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
