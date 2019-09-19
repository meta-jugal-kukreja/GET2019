package com.metacube.assignment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.model.*;

/**
 * Class to map the data of Employee Details
 * @author Jugal
 * Dated 09/16/2019
 */
public class EmployeeDetailsMapper  implements RowMapper<EmployeeDetails>{

	@Override
	public EmployeeDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeDetails employeeDetails = new EmployeeDetails(resultSet.getString("name"), 
				resultSet.getString("gender"), resultSet.getString("email"), resultSet.getString("contact_number"), 
				resultSet.getString("organization"), resultSet.getInt("pass_number"), 
				resultSet.getString("price"), resultSet.getString("vehicle_name"), resultSet.getString("type"), 
				resultSet.getString("vehicle_number"), resultSet.getString("identification"));
		
		return employeeDetails;
	}

}
