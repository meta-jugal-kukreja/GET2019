package com.metacube.assignment.model;

/**
 * This class represents an Employee
 * @author Jugal
 * Dated 09/11/2019
 */
public class Employee {

	private String fullName;
	private String gender;
	private String email;
	private String password;
	private String contactNumber;
	private String organization;
	private String vehicleName;
	private String vehicleNumber;
	private String vehicleType;
	private String vehicleIdentification;
	private String passNumber;
	private String passPrice;
	
	public Employee(String fullName, String gender, String email,
			String password, String contactNumber, String organization,
			String vehicleName, String vehicleNumber, String vehicleType,
			String vehicleIdentification, String passNumber, String passPrice) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.organization = organization;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleIdentification = vehicleIdentification;
		this.passNumber = passNumber;
		this.passPrice = passPrice;
	}
	
	public String getFullName() {
		return fullName;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getVehicleIdentification() {
		return vehicleIdentification;
	}
	public String getPassNumber() {
		return passNumber;
	}
	public String getPassPrice() {
		return passPrice;
	}
}
