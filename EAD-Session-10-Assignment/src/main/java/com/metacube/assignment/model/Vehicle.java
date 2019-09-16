package com.metacube.assignment.model;

/**
 * This class represents a Vehicle
 * @author Jugal
 * Dated 09/11/2019
 */
public class Vehicle {
	
	private String employeeEmail;
	private String vehicleName;
	private String vehicleType;
	private String vehicleNumber;
	private String vehicleIdentification;
	
	public Vehicle(String employeeEmail, String vehicleName,
			String vehicleType, String vehicleNumber,
			String vehicleIdentification) {
		this.employeeEmail = employeeEmail;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleIdentification = vehicleIdentification;
	}

	public Vehicle()
	{
		
	}
	
	//Getter and Setter methods
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void setVehicleIdentification(String vehicleIdentification) {
		this.vehicleIdentification = vehicleIdentification;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getVehicleIdentification() {
		return vehicleIdentification;
	}

}
