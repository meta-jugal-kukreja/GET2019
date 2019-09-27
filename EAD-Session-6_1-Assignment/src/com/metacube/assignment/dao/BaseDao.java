package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Inventory;

/**
 * Interface for base DAO
 * @author Jugal
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	/**
	 * Method to return the list of T objects
	 * @return list
	 */
	public List<T> getList(String query);

	/**
	 * Method to insert new data into database
	 * @param query is the query string
	 * @return {Status} status
	 */
	public Status insertItemToInventory(String query);

	/**
	 * Method to delete the data
	* @param query is the query string
	 * @return {Status} status
	 */
	public Status performUpdate(String query);

	/**
	 * Method to get an item from the inventory
	 * @param query is the query string
	 * @return {Inventory} inventory item
	 */
	public Inventory getAnItemFromInventory(String query);
}
