package com.metacube.assignment.model;

/**
 * This class is the POJO for the Inventory table in the database
 * @author Jugal
 * Dated 09/04/2019
 */
public class Inventory extends BaseEntity {

	String name;
	int quantity;
	
	//Constructors
	public Inventory()
	{
		super();
	}
	public Inventory(int id, String name, int quantity)
	{
		super(id);
		this.name = name;
		this.quantity = quantity;
	}

	//Getter Setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
