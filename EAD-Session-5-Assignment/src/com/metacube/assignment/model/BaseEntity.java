package com.metacube.assignment.model;

/**
 * This class repsents a base entity
 * @author Jugal
 * Dated 08/30/2019
 */
public class BaseEntity {

	private int id;

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
