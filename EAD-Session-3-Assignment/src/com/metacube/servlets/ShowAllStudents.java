package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllStudents
 */
@WebServlet("/ShowAllStudents")
public class ShowAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
			Connection connection = SQLConnection.makeConnection();
			String query = StudentQueries.getDisplayQuery();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			out.print("<html><head><title>Students</title></head><body>");
			out.print("<table border = '1'>");
			out.print("<tr><th>Student Id</th><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr>");
			while (resultSet.next()) {
				out.print("<tr><form action = 'UpdateStudentDetails'>"
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
				+ "<td><input type='submit' name='submitButton' value = 'Update'></form></td></tr>");
			}
			out.print("</table></body></html>");
			out.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
