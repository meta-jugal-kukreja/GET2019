package com.metacube.assignment.classes;

public class Queries {
	public static String getQueryForRegisterEmployee() {
		return "INSERT INTO Employee(name, gender, email, password, contact_number, organization) VALUES(?, ?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForAddVehicle() {
		return "INSERT INTO Vehicle(vehicle_name, type, vehicle_number, employee_Id, identification) VALUES(?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForLogIn() {
		return "SELECT password FROM Employee WHERE email = ? ";
	}
	
	public static String getQueryForEmpId() {
		return "SELECT max(employee_id) FROM Employee";
	}
	
	public static String getQueryForAddPass() {
		return "INSERT INTO Pass(employee_id, price) VALUES(?, ?)";
	}
	
	public static String getEmpId() {
		return "SELECT employee_id FROM Employee WHERE email = ?";
	}
	
	public static String getQueryForEmpDetail() {
		return "SELECT e.employee_id, e.name, e.gender, e.email, e.contact_number, e.organization,"
				+ " v.vehicle_name, v.type, v.vehicle_number, v.identification, p.price FROM Employee e, Vehicle v, Pass p"
				+ " WHERE v.employee_Id = ? and v.employee_Id = p.employee_id and e.employee_id = v.employee_Id";
	}
	
	public static String getQueryForFriendsList() {
		return "SELECT employee_id, name FROM EMPLOYEE WHERE employee_id != ? and organization ="
				+ " (select organization from EMPLOYEE where employee_id = ?)";
	}
}
