package com.metacube.assignment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.model.Employee;

/**
 * Class to map the data of Employee Login
 * @author Jugal
 * Dated 09/16/2019
 */
public class EmployeeLoginMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee employee = new Employee(resultSet.getString("email"));
		return employee;
	}

}
