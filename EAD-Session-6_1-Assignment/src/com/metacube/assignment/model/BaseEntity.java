package com.metacube.assignment.model;

/**
 * Class for base entity representation
 * @author Jugal
 * Dated 09/04/2019
 */
public class BaseEntity {
	private int id;

	//Constructors
    public BaseEntity(int id) {
        this.id = id;
    }
    public BaseEntity(){
        
    }
  
 // Getters Method
    public int getId() {
        return id;
    }
}
