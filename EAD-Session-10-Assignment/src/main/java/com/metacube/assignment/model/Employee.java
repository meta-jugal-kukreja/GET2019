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
	
	public Employee()
	{
		
	}

	public Employee(String fullName, String gender, String email,
			String password, String contactNumber, String organization) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.organization = organization;
	}
	
	public Employee(String fullName, String email, String password)
	{
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}
	
	public Employee(String email)
	{
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}
