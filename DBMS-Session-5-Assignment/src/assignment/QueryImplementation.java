package assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to execute the query and store the result
 * @author Jugal
 * Dated 08/19/2019
 */
public class QueryImplementation {
	
	private Connection connection;
	
	/**
	 * Constructor which helps the program to connect with the database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	QueryImplementation() throws ClassNotFoundException, SQLException{
	
		connection = ConnectTODB.makeConnection();
	}
	
	/**
	 * Assignment 1:
	 * This method executes the query one and stores the result in the list of orders type
	 * @param userId is the user id of the user
	 * @return {List<Orders>} list of order details
	 * @throws SQLException
	 */
	List<Orders> getOrderDetailsOfShippedOrders(String userId) throws SQLException
	{
		if(userId == null)
		{
			System.out.println("No user");
			return  null;
		}
		List<Orders> orderDetailList = new ArrayList<>();
		try
		{
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.getQueryOne(userId));
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while(resultSet.next())
			{
				orderDetailList.add(new Orders(resultSet.getInt(1),  resultSet.getDate(2), resultSet.getDouble(3)));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return orderDetailList;
	}

	/**
	 * Assignment 2:
	 * This method inserts the images of the given product
	 * @param productIds is the product ids
	 * @param imageURLs is the urls of the image
	 * @return {int} length of the resultant table
	 * @throws SQLException
	 */
	int insertImagesOfProduct(int[] productIds, String[] imageURLs) throws SQLException
	{
		if (productIds == null || imageURLs == null) {
			System.out.println("Id or Images Can't be Null");
			return -1;
		}
		try
		{
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.getQueryTwo());
			connection.setAutoCommit(false);
			for (int i = 0; i < productIds.length; i++) {
				statement.setInt(1, productIds[i]);
				statement.setString(2, imageURLs[i]);
				statement.addBatch();
			}
			int[] result = statement.executeBatch();
			connection.commit();
			return result.length;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			connection.rollback();
		}
		return -1;
	}
	
	/**
	 * Assignment 3:
	 * This method executes the query which deletes the products that are not Ordered in Last One Year
	 * @return {int} Number of products deleted
	 * @throws SQLException
	 */
	int deleteProductsNotOrdered() throws SQLException {
		int deletedProducts = 0;
		try {
			connection.setAutoCommit(false);
			checkForeignKeyConstrainys();
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.getQueryThree());
			deletedProducts = statement.executeUpdate();
			connection.commit();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			connection.rollback();
		}
		return deletedProducts;
	}

	/**
	 * Assignment 4:
	 * This method returns List of Top categories along with their No Of Child Categories
	 * @return {List<CategoryDetails>} list of categories
	 */
	List<CategoryDetail> getCategoryDetail() {
		// List to Save the Result i.e., TopMost CAtegory and No Of Child
		List<CategoryDetail> categoryDetailList = new ArrayList<CategoryDetail>();

		try {
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.getQueryFour());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				categoryDetailList.add(new CategoryDetail(resultSet.getString(1), resultSet.getInt(2)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return categoryDetailList;
	}
	
	/**
	 * This methods prints a table
	 * @param table is the table name
	 */
	void printTable(String table)
	{
		try
		{
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.getSelectQuery(table));
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * This method executes the query of foreign key check
	 */
	void checkForeignKeyConstrainys()
	{
		try
		{
			PreparedStatement statement = connection.prepareStatement(StoreFrontQueries.correctForeignConstraint());
			statement.executeQuery();
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
