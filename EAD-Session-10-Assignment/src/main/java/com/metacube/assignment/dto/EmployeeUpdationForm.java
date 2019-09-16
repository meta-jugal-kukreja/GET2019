package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This class represents a data transfer object for Employee Updation
 * @author Jugal
 * Dated 09/11/20189
 */
public class EmployeeUpdationForm {

	@NotBlank
	@Size(min = 2, max = 15, message="{properName}")
	private String fullName;
	@NotBlank
	private String gender;
	@NotBlank(message="{blankEmail}")
	@Size(min = 2, max = 30, message="Length of email must be between {min} and {max}")
	@Pattern(regexp = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$", message = "Email Type is invalid")
	private String email;
	@NotBlank
	@Size(max = 10, message="{contactNumber}")
	@Pattern(regexp = "([0-9]){10}", message = "{invalidNumber}")
	private String contactNumber;
	@NotBlank
	private String organization;
	
	//Getter setter methods
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
}
