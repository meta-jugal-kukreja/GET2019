package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This class represents a data transfer object for Vehicle Registration
 * @author Jugal
 * Dated 09/11/20189
 */
public class VehicleRegistrationForm {

	@NotBlank
	@Size(min = 2, max = 15, message="{vehicleName}")
	@Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "{vehicleName}")
	private String vehicleName;
	@NotBlank
	@Size(max = 15, message="{vehicleNumber}")
	@Pattern(regexp = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$", message = "{vehicleNumber}")
	private String vehicleNumber;
	@NotBlank
	private String type;
	@NotBlank
	private String employeeEmail;
	@NotBlank
	private String identification;
	
	//Getter Setter methods
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
