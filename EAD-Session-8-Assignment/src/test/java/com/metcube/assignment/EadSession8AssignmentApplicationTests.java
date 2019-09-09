package com.metcube.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metcube.assignment.model.Student;

/**
 * This class is for testing methods of Student Class
 * @author Jugal
 * Dated 09/09/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EadSession8AssignmentApplicationTests {

	List<Student> listOfStudents = new ArrayList<>();
	
	@Before
	public void initialize()
	{
		listOfStudents.add(new Student("Jugal", "Kukreja", "Anil Kukreja", "jugal@metacube.com" ,12 , 18));
	}
	
	/**
	 * Test for first name
	 */
	@Test
	public void testGetFirstName() {
		assertEquals("Jugal", listOfStudents.get(0).getFirstName());
	}

	/**
	 * Test for last name
	 */
	@Test
	public void testGetLastName() {
		assertEquals("Kukreja", listOfStudents.get(0).getLastName());
	}
	
	/**
	 * Test for father's name
	 */
	@Test
	public void testGetFatherName() {
		assertEquals("Anil Kukreja", listOfStudents.get(0).getFatherName());	
	}
	
	/**
	 * Test for email
	 */
	@Test
	public void testGetEmailName() {
		assertEquals("jugal@metacube.com", listOfStudents.get(0).getEmail());
	}
	
	/**
	 * Test for student class
	 */
	@Test
	public void testGetStudentClassName() {
		assertEquals(12, listOfStudents.get(0).getStudentClass());
	}
	
	/**
	 * Test for student age
	 */
	@Test
	public void testGetStudentageName() {
		assertEquals(18, listOfStudents.get(0).getStudentAge());
	}
	
}
