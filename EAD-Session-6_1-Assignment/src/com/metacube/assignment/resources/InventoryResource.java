package com.metacube.assignment.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.facade.InventoryFacade;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Inventory;

/**
 * This class contains the implementation of the REST API methods
 * @author Jugal
 * Dated 09/04/2019
 */ 
@Path("/inventory")
public class InventoryResource {
	
	InventoryFacade inventoryFacade = Factory.getInventoryFacade();
	
	/**
	 * Method to get the whole Inventory
	 * @return {String}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getWholeInventory()
	{
		List<Inventory> inventoryList = new ArrayList<>();
		inventoryList = inventoryFacade.getInventory();
		if(inventoryList.size() > 0)
		{
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(inventoryList);
			return inventoryJson;
		}
		else
		{
			return "No Inventory Found";
		}
	}
	
	/**
	 * Method to get an item from the Inventory
	 * @return {String}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String getInventoryItem( @PathParam("name") String name)
	{
		Inventory inventory;
		inventory = inventoryFacade.getInventoryItem(name);
		if(inventory != null)
		{
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(inventory);
			return inventoryJson;
		}
		else
		{
			return "No Inventory Found";
		}
	}

	/**
	 * Method to insert an item in the Inventory
	 * @return {String}
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String insertItemToInventory(Inventory inventory)
	{
		if(inventoryFacade.insertItemToInventory(inventory.getName(), inventory.getQuantity()) == Status.INSERTED)
		{
			return "Data Inserted";
		}
		else
		{
			return "There was an error while inserting the data";
		}
	}
	
	/**
	 * Method to update an item in the Inventory
	 * @return {String}
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String updateAnItemInInventory(Inventory inventory, @PathParam("name") String name)
	{
		if(inventoryFacade.updateAnItemInInventory(name, inventory.getQuantity()) == Status.UPDATED)
		{
			return "Data Updated";
		}
		else
		{
			return "There was an error while updating the data";
		}
	}
	
	/**
	 * Method to update the whole Inventory
	 * @return {String}
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String updateInventory(String inventoryArray)
	{
		Gson gson = new Gson();
		TypeToken<List<Inventory>> token = new TypeToken<List<Inventory>>() {};
		List<Inventory> inventoryList = gson.fromJson(inventoryArray, token.getType());
		inventoryFacade.deleteAllItemsFromInventory();
		if(inventoryList.size() > 0)
		{
			for(Inventory inventory : inventoryList)
			{
				inventoryFacade.insertItemToInventory(inventory.getName(), inventory.getQuantity());
			}
			return "Data Updated";
		}
		else
		{
			return "There was an error while updating the data";
		}
			
	}
	
	/**
	 * Method to delete the Inventory
	 * @return {String}
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteInventory()
	{
		if(inventoryFacade.deleteAllItemsFromInventory() == Status.UPDATED)
		{
			return "Data Updated";
		}
		else
		{
			return "There was an error while updating the data";
		}
	}
	
	/**
	 * Method to delete an item from the Inventory
	 * @return {String}
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String deleteAnItemFromInventory(@PathParam("name") String name)
	{
		if(inventoryFacade.deleteAnItemFromInventory(name) == Status.UPDATED)
		{
			return "Data Updated";
		}
		else
		{
			return "There was an error while updating the data";
		}
	}
}
