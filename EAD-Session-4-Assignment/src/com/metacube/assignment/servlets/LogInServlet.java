package com.metacube.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.assignment.classes.MySQLCon;
import com.metacube.assignment.classes.Queries;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForLogIn());
			statement.setString(1, request.getParameter("email"));
			statement.setString(2, request.getParameter("password"));
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if(request.getParameter("email").equals(resultSet.getString(1))){
				request.setAttribute("employeeEmail", request.getParameter("email"));
				HttpSession session = request.getSession();
				session.setAttribute("email",request.getParameter("email"));
				getServletContext().getRequestDispatcher("/home.jsp").include(request, response);
			}else{
				PrintWriter out = response.getWriter();
				out.print("<html><body>Invalid email or password<br><a href='login.html'>Log In</a></body></html>");
				out.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
