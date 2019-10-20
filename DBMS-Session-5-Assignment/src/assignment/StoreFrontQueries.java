package assignment;

/**
 * This class is used to create the queries for the database
 * 
 * @author Jugal Dated 08/19/2019
 */
public class StoreFrontQueries {

	/**
	 * Assignment 1: Given the id of a user, fetch all orders (Id, Order Date,
	 * Order Total) of that user which are in shipped state. Orders should be
	 * sorted by order date column in chronological order.
	 * 
	 * @param userID
	 *            is the user id
	 */
	static String getQueryOne(String userID) {
		return "SELECT o.order_id, o.order_date, SUM(o.order_amount) "
				+ "FROM orders o, user u WHERE "
				+ "o.email_id = u.email_id AND " + "u.email_id = '" + userID
				+ "' AND  " + "o.order_status = 'Shipped' "
				+ "GROUP BY o.order_id" + " ORDER BY o.order_date" + ";";
	}

	/**
	 * Assignment 2: Insert five or more images of a product using batch insert
	 * technique.
	 */
	static String getQueryTwo() {
		return "INSERT INTO images(product_id, image_url) VALUES(?,?);";
	}

	/**
	 * Assignment 3: Delete all those products which were not ordered by any
	 * Shopper in last 1 year.
	 */
	static String getQueryThree() {
		return "DELETE FROM products" + 
					" WHERE products.product_id" +
					" NOT IN(SELECT product_id FROM(SELECT p.product_id FROM products p, orders o"+
					" WHERE o.product_id = p.product_id AND DATEDIFF(CURDATE(), o.order_date) < 365) AS temporary);";
	}

	/**
	 * Assignment 4: Select and display the category title of all top parent
	 * categories sorted alphabetically and the count of their child categories.
	 */
	static String getQueryFour() {
		return "SELECT p.category_Name AS Top_categories, count(p.category_id) AS No_Of_Childs"
				+ " FROM category p LEFT JOIN category c"
				+ " ON p.category_id = c.parent_category"
				+ " WHERE p.parent_category IS NULL"
				+ " GROUP BY Top_categories" + " ORDER BY p.category_Name;";
	}

	/**
	 * This method makes the query to display a table
	 * 
	 * @param table
	 *            is the table name
	 * @return {String} The SQL query
	 */
	static String getSelectQuery(String table) {
		return "SELECT * FROM " + table + ";";
	}
	
	/**
	 * This method makes the query which checks the foreign key constraints
	 * @return {String} the query
	 */
	static String correctForeignConstraint()
	{
		return "SET FOREIGN_KEY_CHECKS = 0";
	}
}
