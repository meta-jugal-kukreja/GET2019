package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.EmployeeDetails;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;

/**
 * Infterface for DAO
 * @author Jugal
 * Dated 09/12/2019
 */
public interface EmployeeDao {
	
	/**
	 * Method to add employee
	 * @param Employee is the employee 
	 * @return {boolean}
	 */
	public boolean addEmployee(Employee employee);

	/**
	 * Method to get employee by email id
	 * @param email is the email id of the user 
	 * @return {Employee} the Employee
	 */
	public EmployeeDetails getEmployeeById(String email);

	/**
	 * Method to update employee details
	 * @param Employee is the employee 
	 * @return {boolean}
	 */
	public boolean update(Employee employee);

	/**
	 * Method to get all employee
	 * @return {List<Employee>}
	 */
	public boolean addVehicle(Vehicle vehicle);
	
	/**
	 * Method to add pass
	 * @return {boolean}
	 */
	public boolean addPass(Pass pass);
	
	/**
	 * Method to check employee authority
	 * @return {boolean}
	 */
	public boolean checkEmployeeAuthenticity(String email, String password);
	
	/**
	 * Method to get employee's friend list
	 * @return {List<Employee>}
	 */
	public List<Employee> getEmployeeFriendList(String email);

}
