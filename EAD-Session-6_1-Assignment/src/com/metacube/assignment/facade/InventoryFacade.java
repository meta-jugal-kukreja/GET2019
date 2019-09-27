package com.metacube.assignment.facade;

import java.util.List;
import com.metacube.assignment.dao.BaseDao;
import com.metacube.assignment.database.QueriesFactory;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Inventory;

/**
 * This class represents the facade layer of the software
 * @author Jugal
 * Dated 09/04/2019
 */
public class InventoryFacade {

	BaseDao<Inventory> baseDao = Factory.getSQLDAO();
	
	//Method for POST
	public Status insertItemToInventory(String name, int quantity)
	{
		return baseDao.insertItemToInventory(QueriesFactory.postItemToInventory(name, quantity));
	}
	
	//Method for GET
	public List<Inventory> getInventory()
	{
		return baseDao.getList(QueriesFactory.getWholeInventoryQuery());
	}
	//Method for GET
	public Inventory getInventoryItem(String name)
	{
		return baseDao.getAnItemFromInventory(QueriesFactory.getInventoryItemQuery(name));
	}
	
	//Method for DELETE
	public Status deleteAllItemsFromInventory()
	{
		return baseDao.performUpdate(QueriesFactory.deleteItemsFromInventoryQuery());
	}
	
	//Method for DELETE
	public Status deleteAnItemFromInventory(String name)
	{
		return baseDao.performUpdate(QueriesFactory.deleteAnItemFromInventoryQuery(name));
	}
	
	//Method for PUT
	public Status updateAnItemInInventory(String name, int quantity)
	{
		return baseDao.performUpdate(QueriesFactory.updateInventoryQuery(name, quantity));
	}
}
