package com.metacube.assignment.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCon {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Parking_System", "root", "root");
			return connection;
		} catch (ClassNotFoundException e) {
			throw new AssertionError("class not found");
		} catch (SQLException e) {
			throw new AssertionError("SQL connection not found");
		}
	}
}
