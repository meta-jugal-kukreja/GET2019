package com.metacube.assignment.dto;

/**
 * This class represents a data transfer object for Pass
 * @author Jugal
 * Dated 09/11/20189
 */
public class GetPass {

	private String employeeEmail;
	private String passPrice;
	
	//Getter Setter methods
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getPassPrice() {
		return passPrice;
	}
	public void setPassPrice(String passPrice) {
		this.passPrice = passPrice;
	}

}
