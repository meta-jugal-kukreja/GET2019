package com.metacube.assignment.dao.implementation;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.dao.EmployeeDao;
import com.metacube.assignment.mapper.EmployeeDetailsMapper;
import com.metacube.assignment.mapper.EmployeeFriendsMapper;
import com.metacube.assignment.mapper.EmployeeLoginMapper;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.EmployeeDetails;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;


@Repository
public class EmployeeDaoImplementation implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_USER = "SELECT  e.name, e.gender, e.email, e.contact_number, e.organization,"
			+ " v.vehicle_name, v.type, v.vehicle_number, v.identification, p.pass_number, p.price FROM Employee e, Vehicle v, Pass p"
			+ " WHERE e.email = ? and v.email = e.email and e.email = p.email";
	private final String SQL_UPDATE_USER = "UPDATE Employee SET name = ?, gender = ?, contact_number = ?, organization = ? WHERE email = ?";
	private final String SQL_INSERT_USER = "INSERT INTO Employee(name, gender, email, password, contact_number, organization) VALUES(?,?,?,?,?,?)";
	private final String SQL_INSERT_VEHICLE = "INSERT INTO Vehicle(vehicle_name, type, vehicle_number, email, identification) VALUES(?, ?, ?, ?, ?)";
	private final String SQL_INSERT_PASS = "INSERT INTO Pass(email, price) VALUES(?, ?)";
	private final String SQL_CHECK_EMPLOYEE = "SELECT email FROM Employee WHERE email = ? AND password = ?";
	private final String SQL_GET_FRIEND_LIST = "SELECT email, name FROM EMPLOYEE WHERE email != ? and organization ="
			+ " (select organization from EMPLOYEE where email = ?)";

	@Autowired
	public EmployeeDaoImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public boolean addEmployee(Employee employee) {
		int row = jdbcTemplate.update(SQL_INSERT_USER, employee.getFullName(), employee.getGender(), employee.getEmail(), employee.getPassword(),
				employee.getContactNumber(), employee.getOrganization());
		return row > 0 ? true : false;
	}

	@Override
	public EmployeeDetails getEmployeeById(String email) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { email }, new EmployeeDetailsMapper());
	}

	@Override
	public boolean update(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_USER, employee.getFullName(), employee.getGender(),
				employee.getContactNumber(), employee.getOrganization(), employee.getEmail()) > 0;
	}
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		int row = jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicle.getVehicleName(), vehicle.getVehicleType(), vehicle.getVehicleNumber(),
				vehicle.getEmployeeEmail(), vehicle.getVehicleIdentification());
		return row > 0 ? true : false;
	}
	@Override
	public boolean addPass(Pass pass) {
		int row = jdbcTemplate.update(SQL_INSERT_PASS, pass.getEmployeeEmail(), pass.getPassPrice());
		return row > 0 ? true : false;
	}
	@Override
	public boolean checkEmployeeAuthenticity(String email, String password) {
		Employee employee = jdbcTemplate.queryForObject(SQL_CHECK_EMPLOYEE, new Object[] {email, password}, new EmployeeLoginMapper());
		if(employee.getEmail() == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Employee> getEmployeeFriendList(String email) {
		return jdbcTemplate.query(SQL_GET_FRIEND_LIST, new Object[] {email, email}, new EmployeeFriendsMapper());
	}
}
