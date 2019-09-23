package com.metacube.assignment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.assignment.dto.StudentForm;
import com.metacube.assignment.repository.StudentRepository;

/**
 * This is the test class
 * @author Jugal
 * Dated 09/18/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EadSession12AssignmentApplicationTests {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	public void setStudentDao(StudentRepository repository) {
		this.repository = repository;
	}

	StudentForm student;
	
	@Test
	public void testgetStudents()
	{
		assertEquals("jugal.kukreja@metacube.com", repository.findAll().get(0).getEmail());
	}

}
