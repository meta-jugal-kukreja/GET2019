package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentDetails
 */
@WebServlet("/AddStudentDetails")
public class AddStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("s_first_name");
		String lastName = request.getParameter("s_last_name");
		String fatherName = request.getParameter("s_father_name");
		String email = request.getParameter("s_email");
		String studentClass =request.getParameter("s_class");
		String age = request.getParameter("s_age");
		try
		{
			Connection connection = SQLConnection.makeConnection();
			String query = StudentQueries.getInsertionQuery(firstName, lastName, fatherName, email, Integer.parseInt(studentClass), Integer.parseInt(age));
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(!(statement.executeUpdate() <= 0))
			{
				out.print("Data is successfully inserted");
				connection.commit();
			}
			else
			{
				connection.rollback();
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
