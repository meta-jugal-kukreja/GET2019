package com.metacube.assignment.model;

/**
 * This class represents a Pass
 * @author Jugal
 * Dated 09/11/2019
 */
public class Pass {
	
	private int passNumber;
	private String employeeEmail;
	private String passPrice;
	
	public Pass(int passNumber, String employeeEmail, String passPrice) {
		this.passNumber = passNumber;
		this.employeeEmail = employeeEmail;
		this.passPrice = passPrice;
	}

	public Pass()
	{
		
	}
	
	//Getter and Setter methods
	public void setPassNumber(int passNumber) {
		this.passNumber = passNumber;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setPassPrice(String passPrice) {
		this.passPrice = passPrice;
	}

	public int getPassNumber() {
		return passNumber;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getPassPrice() {
		return passPrice;
	}
}
