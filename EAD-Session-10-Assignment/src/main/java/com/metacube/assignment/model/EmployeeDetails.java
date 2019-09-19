package com.metacube.assignment.model;

/**
 * This class represents an Employee full Details
 * @author Jugal
 * Dated 09/11/2019
 */
public class EmployeeDetails {

	private String fullName;
	private String gender;
	private String email;
	private String contactNumber;
	private String organization;
	private int passNumber;
	private String passPrice;
	private String vehicleName;
	private String vehicleType;
	private String vehicleNumber;
	private String vehicleIdentification;
	
	public EmployeeDetails()
	{
		
	}

	public EmployeeDetails(String fullName, String gender, String email,
			String contactNumber, String organization,
			int passNumber, String passPrice, String vehicleName,
			String vehicleType, String vehicleNumber,
			String vehicleIdentification) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
		this.organization = organization;
		this.passNumber = passNumber;
		this.passPrice = passPrice;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleIdentification = vehicleIdentification;
	}

	//Getter and Setter methods
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(int passNumber) {
		this.passNumber = passNumber;
	}

	public String getPassPrice() {
		return passPrice;
	}

	public void setPassPrice(String passPrice) {
		this.passPrice = passPrice;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleIdentification() {
		return vehicleIdentification;
	}

	public void setVehicleIdentification(String vehicleIdentification) {
		this.vehicleIdentification = vehicleIdentification;
	}
	
}
