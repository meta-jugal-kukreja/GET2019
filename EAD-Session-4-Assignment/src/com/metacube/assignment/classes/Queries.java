package com.metacube.assignment.classes;

public class Queries {
	public static String getQueryForRegisterEmployee() {
		return "INSERT INTO Employee(name, gender, email, password, contact_number, organization) VALUES(?, ?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForAddVehicle() {
		return "INSERT INTO Vehicle(vehicle_name, type, vehicle_number, email, identification) VALUES(?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForLogIn() {
		return "SELECT email FROM Employee WHERE email = ? AND password = ?";
	}
	
	public static String getQueryForAddPass() {
		return "INSERT INTO Pass(email, price) VALUES(?, ?)";
	}
	
	public static String getEmployeeEmail() {
		return "SELECT email FROM Employee WHERE email = ?";
	}
	
	public static String getQueryForEmpDetail() {
		return "SELECT  e.name, e.gender, e.email, e.contact_number, e.organization,"
				+ " v.vehicle_name, v.type, v.vehicle_number, v.identification, p.pass_number, p.price FROM Employee e, Vehicle v, Pass p"
				+ " WHERE e.email = ? and v.email = e.email and e.email = p.email";
	}
	
	public static String getQueryForFriendsList() {
		return "SELECT email, name FROM EMPLOYEE WHERE email != ? and organization ="
				+ " (select organization from EMPLOYEE where email = ?)";
	}
}
