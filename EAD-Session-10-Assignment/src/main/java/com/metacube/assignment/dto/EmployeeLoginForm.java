package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This class represents a data transfer object for Employee Login
 * @author Jugal
 * Dated 09/11/20189
 */
public class EmployeeLoginForm {

	@NotBlank
	@Size(min = 2, max = 30, message="{blankEmail}")
	private String email;
	@NotBlank
	private String password;
	
	//Getter Setter methods
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
}
