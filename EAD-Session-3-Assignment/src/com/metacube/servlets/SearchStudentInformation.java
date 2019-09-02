package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudentInformation")
public class SearchStudentInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ResultSet resultSet;
		String firstName = request.getParameter("search_by_fname");
		String lastName = request.getParameter("search_by_lname");
		String student_class = request.getParameter("search_by_class");
		if(student_class != null)
		{
			resultSet = displayResultAccordingToClass(student_class);
		}
		else
		{
			resultSet = displayResultAccordingToName(firstName, lastName);
		}
		out.print("<html><head><title>Students</title></head><body>");
		out.print("<table border = '1'>");
		out.print("<tr><th>Student Id</th><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr>");
		try {
			while (resultSet.next()) {
				out.print("<tr><form action = ''>"
				+"<td><input type = 'text' name='studentId' readonly value ='"
				+ resultSet.getInt(1) + "'></td>"
				+ "<td><input type = 'text' name='email' readonly value ='"
				+ resultSet.getString(2) + "'></td>"
				+ "<td><input type = 'text' name='firstName' readonly  value ='" + resultSet.getString(3)
				+ "'></td>"
				+ "<td><input type = 'text' name='lastName'  readonly value ='"
				+ resultSet.getString(4)
				+ "'></td>"
				+ "<td><input type = 'text' name='fatherName' readonly value ='"
				+ resultSet.getString(5)
				+ "'></td>"
				+ "<td><input type = 'text' name='class' readonly value ='"
				+ resultSet.getInt(6)
				+ "'></td>"
				+ "<td><input type = 'text' name='age' readonly value ='"
				+ resultSet.getInt(7)
				+ "'></td>"
				+ "</form></td></tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("</table></body></html>");
		out.close();
	}

	/**
	 * Helper method to search according to class
	 * @param student_class is the student class
	 * @return {ResultSet}
	 */
	public ResultSet displayResultAccordingToClass(String student_class)
	{
		ResultSet resultSet = null;
		try
		{
			Connection connection = SQLConnection.makeConnection();
			String query = StudentQueries.getSearchQuery(Integer.parseInt(student_class));
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Helper method to search according to name
	 * @param firstName is the first name of the student
	 * @param lastName is the last name of the student
	 * @return {ResultSet}
	 */
	public ResultSet displayResultAccordingToName(String firstName, String lastName)
	{
		ResultSet resultSet = null;
		try
		{
			Connection connection = SQLConnection.makeConnection();
			String query = StudentQueries.getSearchQuery(firstName, lastName);
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return resultSet;
	}
}
