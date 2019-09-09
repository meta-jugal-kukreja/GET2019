package com.metcube.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metcube.assignment.dto.StudentForm;
import com.metcube.assignment.model.Student;
import com.metcube.assignment.service.StudentService;
import com.metcube.assignment.service.implementation.StudentServiceImplementation;

/**
 * This class represents the controller
 * @author Jugal
 * Dated 09/09/2019
 */
@Controller
public class AppController {
	
	@Value("${home.notice}")
	private String notice;
	
	/**
	 * Method to show the home page
	 * @return {String} view name
	 */
	@GetMapping("/home")
	public String showHomePage(Model model)
	{
		model.addAttribute("notice", notice);
		return "students/home";
	}
	
	/**
	 * Method to show the Student Entry Form
	 * @return {String} view name
	 */
	@GetMapping("/home/studentForm")
	public String showUserForm(Model model) 
	{
		model.addAttribute(new StudentForm());
		return "students/student_form"; 
	}
	
	/**
	 * Method to show the details entered in Student Entry Form
	 * @return {String} view name
	 */
	@PostMapping("/home/studentForm")
	public String signUp(@Validated StudentForm student, BindingResult result)
	{
		if(result.hasErrors())
		{
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "students/student_form";
		}
		else
		{
			System.out.println("Student First Name : " + student.getFirstName());
			System.out.println("Student Last Name : " + student.getLastName());
			System.out.println("Student Father'sName : " + student.getFatherName());
			System.out.println("Student email : " + student.getEmail());
			System.out.println("Student class : " + student.getStudentClass());
			System.out.println("Student age : " + student.getStudentAge());
			return "redirect:/home";
		}
	}
	
	/**
	 * Method to show the student list
	 * @return {String} view name
	 */
	@GetMapping("/home/showStudents")
	public String showStudents(Model model)
	{
		StudentService studentService = new StudentServiceImplementation();
		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents = studentService.getStudentsList();
		model.addAttribute("students", listOfStudents);
		return "students/student_list";
	}
}
