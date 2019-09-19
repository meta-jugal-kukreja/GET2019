package com.metacube.assignment.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.dao.EmployeeDao;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.EmployeeDetails;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;
import com.metacube.assignment.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeDetails findEmployeeById(String email) {
		return employeeDao.getEmployeeById(email);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return employeeDao.addVehicle(vehicle);
	}

	@Override
	public boolean addPass(Pass pass) {
		return employeeDao.addPass(pass);
	}

	@Override
	public boolean checkEmployeeAuthenticity(String email, String password) {
		return employeeDao.checkEmployeeAuthenticity(email, password);
	}

	@Override
	public List<Employee> getEmployeeFriendList(String email) {
		return employeeDao.getEmployeeFriendList(email);
	}
}
