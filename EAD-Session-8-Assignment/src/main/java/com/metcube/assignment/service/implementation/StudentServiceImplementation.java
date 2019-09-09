package com.metcube.assignment.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metcube.assignment.model.Student;
import com.metcube.assignment.service.StudentService;

/**
 * This class is the implementation of the Student Service
 * @author Jugal
 * Dated 09/09/2019
 */
@Service 
public class StudentServiceImplementation implements StudentService {

	@Override
	public List<Student> getStudentsList() {
		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents.add(new Student("Jugal", "Kukreja", "Anil Kukreja", "jugal@metacube.com" ,12 , 18));
		listOfStudents.add(new Student("Aman", "Gautam", "Mr. Gautam", "aman@metacube.com" ,10 , 16));
		listOfStudents.add(new Student("Mahendar", "Singh", "Mr. Singh", "mahendar@metacube.com" ,11 , 17));
		listOfStudents.add(new Student("Anmol", "Babbar", "Mr. Babbar", "anmol@metacube.com" ,12 , 18));
		return listOfStudents;
	}

}
