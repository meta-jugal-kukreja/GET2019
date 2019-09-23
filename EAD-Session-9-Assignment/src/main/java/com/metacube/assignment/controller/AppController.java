package com.metacube.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.assignment.dto.EmployeeRegistrationForm;
import com.metacube.assignment.dto.EmployeeLoginForm;
import com.metacube.assignment.dto.GetPass;
import com.metacube.assignment.dto.VehicleRegistrationForm;
import com.metacube.assignment.model.Employee;

/**
 * This class represents a controller
 * @author Jugal
 * Dated 09/11/2019
 */
@Controller
public class AppController {
	
	List<Employee> employeeList = new ArrayList<>();

	// show employee registration form
	@GetMapping("/employeeRegistration")
	public String showEmployeeRegistrationForm(Model model) {
		model.addAttribute("employeeRegistrationForm",
				new EmployeeRegistrationForm());
		return "users/employee_registration_form";
	}

	// method to register employee
	@PostMapping("/employeeRegistration")
	public String doEmployeeRegister(
			@Validated EmployeeRegistrationForm registeringEmployee,
			BindingResult result) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form",
					"Please fill all the details");
			result.addError(objectError);
			return "users/employee_registration_form";
		} else {
			return "redirect:/vehicleRegistration";
		}
	}

	// show employee login form
	@GetMapping("/employeeLogin")
	public String showEmployeeLoginForm(Model model) {
		model.addAttribute("employeeLoginForm", new EmployeeLoginForm());
		return "users/employee_login_form";
	}

	// Method to login employee
	@PostMapping("/employeeLogin")
	public String doSignIn(@Validated EmployeeLoginForm loggingEmployee,
			BindingResult result) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form",
					"Please fill all the details");
			result.addError(objectError);
			return "users/employee_login_form";
		} else {
			return "redirect:/home";
		}
	}

	// show vehicle registration form
	@GetMapping("/vehicleRegistration")
	public String showVehicleRegistrationForm(Model model) {
		model.addAttribute("vehicleRegistrationForm",
				new VehicleRegistrationForm());
		return "users/vehicle_registration_form";
	}

	// Method to register vehicle
	@PostMapping("/vehicleRegistration")
	public String doVehicleRegister(
			@Validated VehicleRegistrationForm registeringVehicle,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form",
					"Please fill all the details");
			result.addError(objectError);
			return "users/vehicle_registration_form";
		} else {
			String selectedVehicleType = registeringVehicle.getType();
			model.addAttribute("selectedVehicleType", selectedVehicleType);
			model.addAttribute("getPass", new GetPass());
			return "users/pass_details";
		}
	}

	// show friends list
	@GetMapping("/home/friendsList")
	public String showFriendsList(Model model) {
		employeeList = null;
		employeeList.add(new Employee("Jugal Kukreja", "Male",
				"jugal@metacube.com", "Jugal@1997", "97829196918", "Metacube",
				"CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		employeeList.add(new Employee("Jugal Kukreja", "Male",
				"jugal1@metacube.com", "Jugal@1997", "97829196918", "Metacube",
				"CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		employeeList.add(new Employee("Jugal Kukreja", "Male",
				"jugal12@metacube.com", "Jugal@1997", "97829196918",
				"Metacube", "CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		employeeList.add(new Employee("Jugal Kukreja", "Male",
				"jugal13@metacube.com", "Jugal@1997", "97829196918",
				"Metacube", "CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		employeeList.add(new Employee("Jugal Kukreja", "Male",
				"jugal14@metacube.com", "Jugal@1997", "97829196918",
				"Metacube", "CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		model.addAttribute("employeeList", employeeList);
		return "users/friend_list";
	}

	// show home page
	@PostMapping("/home")
	public String showHomePage(Model model) {
		model.addAttribute("employee", new Employee("Jugal Kukreja", "Male",
				"jugal@metacube.com", "Jugal@1997", "97829196918", "Metacube",
				"CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		return "users/home";
	}

	// show update employee form
	@GetMapping(value = "/employee/{id}/update")
	public String showUpdateEmployeeForm(@PathVariable("id") String email, Model model) {
		model.addAttribute("employee_email", email);
		model.addAttribute("employeeRegistrationForm", new EmployeeRegistrationForm());
		return "users/employee_registration_form";
	}
	
	// show friends details
	@GetMapping(value = "/employee/{id}/viewProfile")
	public String showFriendDetails(@PathVariable("id") String email, Model model) {
		model.addAttribute("employee", new Employee("Jugal Kukreja", "Male",
				email, "Jugal@1997", "97829196918", "Metacube",
				"CB Twister", "RJ 27 SW 0977", "Motor Cycle",
				"No Side Mirrors", "1", "0.14"));
		return "users/friend_details";
	}
}
