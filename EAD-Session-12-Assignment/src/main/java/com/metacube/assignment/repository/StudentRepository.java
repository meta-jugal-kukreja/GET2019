package com.metacube.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.model.Student;

/**
 * This class represents the Repository for the application
 * @author Jugal
 * Dated 09/18/2019
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	/**
	 * Method to find student with first name
	 * @param studentFirstName is the student's first name
	 * @return {List<Student>}
	 */
	public List<Student> findByFirstNameContainingIgnoreCase(String studentFirstName);
	
	/**
	 * Method to find student with email id
	 * @param studentEmail is the student's email
	 * @return {List<Student>}
	 */
	public List<Student> findByEmailContainingIgnoreCase(String studentEmail);
}
