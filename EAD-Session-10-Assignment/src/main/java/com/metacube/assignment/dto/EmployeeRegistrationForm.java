package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This class represents a data transfer object for Employee Registration
 * @author Jugal
 * Dated 09/11/20189
 */
public class EmployeeRegistrationForm {
	
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
//	@Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}", message = "{invalidPassword}")
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank
	@Size(max = 10, message="{contactNumber}")
	@Pattern(regexp = "([0-9]){10}", message = "{invalidNumber}")
	private String contactNumber;
	@NotBlank
	private String organization;
	
	//Getter Setter methods
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
