package com.metcube.assignment.service;

import java.util.List;

import com.metcube.assignment.model.Student;


public interface StudentService {

	/**
	 * Method to get all users
	 * @return list of users
	 */
	public abstract List<Student> getStudentsList();

}
