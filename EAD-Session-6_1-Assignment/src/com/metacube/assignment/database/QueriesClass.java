package com.metacube.assignment.database;

public class QueriesClass {

	/**
	 * Method to generate query string to get the whole inventory
	 * @return {String} query string
	 */
	public static String getWholeInventoryQuery()
	{
		return "SELECT  * FROM Inventory;";
	}
	
	/**
	 * Method to generate query string to get an item from inventory
	 * @param name is the name of the item
	 * @return {String} query string
	 */
	public static String getInventoryItemQuery(String name)
	{
		return "SELECT  * FROM Inventory WHERE name ='" + name + "';";
	}
	
	/**
	 * Method to generate query string to update an item from inventory
	 * @param name is the name of the item
	 * @param quantity is the item quantity
	 * @return {String} query string
	 */
	public static String updateInventoryQuery(String name, int quantity)
	{
		return "UPDATE Inventory SET quantity=" + quantity + " WHERE name = '" + name + "'";
	}
	
	/**
	 * Method to generate query string to delete all items from inventory
	 * @return {String} query string
	 */
	public static String deleteItemsFromInventoryQuery()
	{
		return "TRUNCATE TABLE Inventory;";
	}
	
	/**
	 * Method to generate query string to delete an item from inventory
	 * @param name is the name of the item
	 * @return {String} query string
	 */
	public static String deleteAnItemFromInventoryQuery(String name)
	{
		return "DELETE FROM Inventory WHERE name='" + name + "';";
	}
	
	/**
	 * Method to generate query string to add an item from inventory
	 * @param name is the name of the item
	 * @param quantity is the item quantity
	 * @return {String} query string
	 */
	public static String postItemToInventory(String name, int quantity)
	{
		return "INSERT INTO Inventory (name, quantity) VALUES ('" + name + "'," + quantity + ");";
	}
}
