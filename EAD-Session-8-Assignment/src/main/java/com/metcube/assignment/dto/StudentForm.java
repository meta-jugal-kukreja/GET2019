package com.metcube.assignment.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This class represents a Data Transfer object for the student form
 * @author Jugal
 * Dated 09/09/2019
 */
public class StudentForm {

	@NotBlank
	@Size(min = 2, max =  7, message="First {properName}")
	private String firstName;
	@NotBlank
	@Size(min = 2, max =  7, message="Last {properName}")
	private String lastName;
	@NotBlank
	@Size(min = 2, max =  15, message="Father's {properName}")
	private String fatherName;
	@NotBlank
	@Size(min = 2, max =  30, message="{blankEmail}")
	private String email;
	@Min(value = 1, message="{studentClass}")
	@Max(value = 12, message="{studentClass}")
	private int studentClass;
	@Min(value = 7, message="{studentAge}")
	@Max(value = 18, message="{studentAge}")
	private int studentAge;
	
	//Getter Setter methods
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
}
