package com.metacube.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the Student_Information Table
 * @author Jugal
 * Dated 09/16/2019
 */
@Entity
@Table(name="student_information")
public class Student {

	@Id
	@Column(name="student_id")
	int id;
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(name="father_name")
	String fatherName;
	@Column(name="email_id")
	String email;
	@Column(name="class")
	String studentClass;
	@Column(name="age")
	String studentAge;
	
	public Student() {
	}
	
	//Getter Setter methods
	public String getStudentAge() {
		return studentAge;
	}
	
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}