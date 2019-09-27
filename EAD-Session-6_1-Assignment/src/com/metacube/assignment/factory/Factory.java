package com.metacube.assignment.factory;

import java.sql.SQLException;

import com.metacube.assignment.dao.BaseDao;
import com.metacube.assignment.dao.SQLDAO;
import com.metacube.assignment.facade.InventoryFacade;
import com.metacube.assignment.model.Inventory;

/**
 * This class represents a factory to create objects
 * @author Jugal
 * Dated 09/04/2019
 */
public class Factory {

	/**
	 * Method to create InventoryFacade object
	 * @return {InventoryFacade} InventoryFacade object
	 */
	public static InventoryFacade getInventoryFacade()
	{
		return new InventoryFacade();
	}
	
	/**
	 * Method to create BaseDao<Inventory> object
	 * @return {BaseDao<Inventory>} BaseDao<Inventory> object
	 */
	public static BaseDao<Inventory> getSQLDAO()
	{
		try {
			return new SQLDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
