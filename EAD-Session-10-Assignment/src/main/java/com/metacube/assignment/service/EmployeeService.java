package com.metacube.assignment.service;

import java.util.List;

import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.EmployeeDetails;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;

public interface EmployeeService {
	
	/**
	 * Method to get Employee by Id
	 * @param email is the email id of a Employee
	 * @return {Employee} The Employee
	 */
	public abstract EmployeeDetails findEmployeeById(String email);
	
	/**
	 * Method update Employee 
	 * @param employee is the Employee whose details is to be updated
	 * @return {boolean} whether the employee details got updated or not
	 */
	public abstract boolean updateEmployee(Employee employee);
	
	/**
	 * Method add Employee 
	 * @param employee is the Employee whose details is to be added
	 * @return {boolean} whether the employee details got added or not
	 */
	public abstract boolean addEmployee(Employee employee);
	
	/**
	 * Method add vehicle 
	 * @param vehicle is the vehicle whose details is to be added
	 * @return {boolean} whether the vehicle details got added or not
	 */
	public abstract boolean addVehicle(Vehicle vehicle);
	
	/**
	 * Method add pass 
	 * @param employee is the pass whose details is to be added
	 * @return {boolean} whether the pass details got added or not
	 */
	public abstract boolean addPass(Pass pass);
	
	/**
	 * Method check employee authenticity
	 * @param email is the employee email
	 * @param password is the employee password
	 * @return {boolean} whether the pass details got added or not
	 */
	public abstract boolean checkEmployeeAuthenticity(String email, String password);
	
	/**
	 * Method  to get the friends list of an employee
	 * @param email is the email of the employee whose friend's list is to be searched
	 * @return {List<Employee>} is the friend lis
	 */
	public abstract List<Employee> getEmployeeFriendList(String email);

}
