package com.metcube.assignment.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity class for Student
 * @author Jugal
 * Dated 09/09/2019
 */
public class Student {
	
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
	@Size(min = 2, max =  20, message="{blankEmail}")
	private String email;
	@NotBlank
	@Size(min = 1, max =  12, message="{studentClass}")
	private int studentClass;
	@NotBlank
	@Size(min = 7, max =  19, message="{studentAge}")
	private int studentAge;
	
	//Constructor
	public Student(String firstName, String lastName, String fatherName, String email, int studentClass, int studentAge)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.studentAge = studentAge;
	}
	
	//Getter methods
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getEmail() {
		return email;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public int getStudentAge() {
		return studentAge;
	}
}
