package com.metacube.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.dto.EmployeeRegistrationForm;
import com.metacube.assignment.dto.EmployeeLoginForm;
import com.metacube.assignment.dto.EmployeeUpdationForm;
import com.metacube.assignment.dto.GetPass;
import com.metacube.assignment.dto.VehicleRegistrationForm;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.EmployeeDetails;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;
import com.metacube.assignment.service.EmployeeService;
import com.metacube.assignment.util.DTOUtil;

/**
 * This class represents a controller
 * @author Jugal 
 * Dated 09/11/2019
 */
@Controller
public class AppController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * Method to show the employee Registration form
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/employeeRegistration")
	public String showEmployeeRegistrationForm(Model model) {
		model.addAttribute("employeeRegistrationForm",
				new EmployeeRegistrationForm());
		return "users/employee_registration_form";
	}

	/**
	 * Method to register employee
	 * @param registeringEmployee is the registering employee DTO
	 * @param result is the binding result
	 * @param attribute is the redirecting attribute
	 * @param request is the HttpServletRequest
	 * @return {String} The view name
	 */
	@PostMapping("/employeeRegistration")
	public String doEmployeeRegister(@Validated EmployeeRegistrationForm registeringEmployee,BindingResult result, 
			RedirectAttributes attribute, HttpServletRequest request) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form",
					"Please fill all the details");
			result.addError(objectError);
			return "users/employee_registration_form";
		} 
		else 
		{
			try {
				if (!registeringEmployee.getPassword().equals(registeringEmployee.getConfirmPassword())) {
					ObjectError objectError = new ObjectError("Password","Passwords Doesn't Match!");
					result.addError(objectError);
					return "users/employee_registration_form";
				} else {
					employeeService.addEmployee(DTOUtil.map(registeringEmployee, Employee.class));
					attribute.addFlashAttribute("message", "Welcome " + registeringEmployee.getFullName() + "(" + registeringEmployee.getEmail() + ")");
					attribute.addFlashAttribute("employee_email", registeringEmployee.getEmail());
					HttpSession oldSession = request.getSession(false);
					if (oldSession != null) {
						oldSession.invalidate();
					}
					HttpSession newSession = request.getSession(true);
					newSession.setMaxInactiveInterval(5 * 60);
					newSession.setAttribute("email", registeringEmployee.getEmail());
					return "redirect:/vehicleRegistration";
				}
			} catch (DuplicateKeyException e) {
				ObjectError error = new ObjectError("Exception","Email must be unique");
				result.addError(error);
				return "users/employee_registration_form";
			}
		}
	}

	/**
	 * Method to show the employee Login form
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/employeeLogin")
	public String showEmployeeLoginForm(Model model) {
		model.addAttribute("employeeLoginForm", new EmployeeLoginForm());
		return "users/employee_login_form";
	}

	/**
	 * Method to login employee
	 * @param loggingEmployee is the Logging Employee DTO
	 * @param result is the binding result
	 * @param attribute is the redirecting attribute
	 * @param request is the HttpServletRequest
	 * @return {String} The view name
	 */
	@PostMapping("/employeeLogin")
	public String doSignIn(@Validated EmployeeLoginForm loggingEmployee, BindingResult result, RedirectAttributes attribute, 
			HttpServletRequest request) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "users/employee_login_form";
		} else if (employeeService.checkEmployeeAuthenticity(loggingEmployee.getEmail(), loggingEmployee.getPassword())) {
			EmployeeDetails employeeDetails = DTOUtil.map(employeeService.findEmployeeById(loggingEmployee.getEmail()),EmployeeDetails.class);
			attribute.addFlashAttribute("employee", employeeDetails);
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(5 * 60);
			newSession.setAttribute("email", loggingEmployee.getEmail());
		} else {
			attribute.addFlashAttribute("css", "danger");
			attribute.addFlashAttribute("msg", "User not found");
		}
		return "redirect:/home";
	}

	/**
	 * Method to show the vehicle Registration form
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/vehicleRegistration")
	public String showVehicleRegistrationForm(Model model) {
		model.addAttribute("vehicleRegistrationForm", new VehicleRegistrationForm());
		return "users/vehicle_registration_form";
	}

	/**
	 * Method to register vehicle
	 * @param registeringVehicle is the Registering Vehicle DTO
	 * @param result is the binding result
	 * @param attribute is the redirecting attribute
	 * @return {String} The view name
	 */
	@PostMapping("/vehicleRegistration")
	public String doVehicleRegister(@Validated VehicleRegistrationForm registeringVehicle, BindingResult result,  RedirectAttributes attribute) {
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "users/vehicle_registration_form";
		} else {
			employeeService.addVehicle(DTOUtil.map(registeringVehicle, Vehicle.class));
			attribute.addFlashAttribute("selectedVehicleType", registeringVehicle.getType());
			attribute.addFlashAttribute("employee_email", registeringVehicle.getEmployeeEmail());
			return "redirect:/getPass";
		}
	}

	/**
	 * Method to show the create pass form
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/getPass")
	public String showPassDetailsPage(Model model)
	{
		model.addAttribute(new GetPass());
		return "users/pass_details";
	}
	
	/**
	 * Method to create pass
	 * @param pass is the Pass DTO
	 * @param result is the binding result
	 * @param attribute is the redirecting attribute
	 * @return {String} The view name
	 */
	@PostMapping("/getPass")
	public String validatePassDetailsPage(@Validated GetPass pass, BindingResult result,  RedirectAttributes attribute)
	{
		employeeService.addPass(DTOUtil.map(pass, Pass.class));
		EmployeeDetails employee =  DTOUtil.map(employeeService.findEmployeeById(pass.getEmployeeEmail()),EmployeeDetails.class);
		attribute.addFlashAttribute("employee", employee);
		return "redirect:/home";
	}
	
	/**
	 * Method to show the home page
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/home")
	public String showHomePage(Model model) {
		return "users/home";
	}
	
	/**
	 * Method to show the employee friend list
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/home/employee/{email}/friends")
	public String showFriendsList(@PathVariable("email") String email, Model model) {
		List<Employee> friendList = new ArrayList<>();
		friendList = employeeService.getEmployeeFriendList(email);
		model.addAttribute("employeeFriendsList", friendList);
		return "users/friend_list";
	}

	/**
	 * Method to show the employee update details form
	 * @param email is the employee email
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/home/employee/{email}/update")
	public String showUpdateEmployeeForm(@PathVariable("email") String email, Model model) {
		EmployeeDetails employee =  DTOUtil.map(employeeService.findEmployeeById(email),EmployeeDetails.class);
		model.addAttribute("employee_email", employee.getEmail());
		model.addAttribute("employeeUpdationForm", new EmployeeUpdationForm());
		return "users/employee_updation_form";
	}
	
	/**
	 * Method to update employee details
	 * @param updatingEmployee is the Updating Employee DTO
	 * @param result is the binding result
	 * @param attribute is the redirecting attribute
	 * @return {String} The view name
	 */
	@PostMapping("/home/employee/{email}/update")
	public String updateEmployee(RedirectAttributes attribute, @Validated EmployeeUpdationForm updatingEmployee, 
			BindingResult result) 
	{
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "users/employee_updation_form";
		} 
		else 
		{
			employeeService.updateEmployee(DTOUtil.map(updatingEmployee, Employee.class));
			attribute.addFlashAttribute("message", "Data Updated");
			EmployeeDetails employee =  DTOUtil.map(employeeService.findEmployeeById(updatingEmployee.getEmail()),EmployeeDetails.class);
			attribute.addFlashAttribute("employee", employee);
			return "redirect:/home";
		}
	}

	/**
	 * Method to show the employee friend's details
	 * @param email is the employee email
	 * @param model is the model attribute
	 * @return {String} The view name
	 */
	@GetMapping("/home/employee/{email}/viewProfile")
	public String showFriendDetails(@PathVariable("email") String email, Model model) {
		EmployeeDetails employee =  DTOUtil.map(employeeService.findEmployeeById(email),EmployeeDetails.class);
		model.addAttribute("employee", employee);
		return "users/friend_details";
	}
	
	/**
	 * Method to logout the user
	 * @param request is the HttpServletRequest
	 * @return {String} The view name
	 */
	@GetMapping("/home/employee/logout")
	public String logoutUser(HttpServletRequest request)
	{
		HttpSession session= request.getSession(false);
		if(session != null){
			session.removeAttribute("email");
		}
		return "redirect:/employeeLogin";
	}
}
