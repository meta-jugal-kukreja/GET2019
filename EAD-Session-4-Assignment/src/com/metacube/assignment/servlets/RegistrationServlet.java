package com.metacube.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
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
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForRegisterEmployee());
			statement.setString(1, request.getParameter("full_name"));
			statement.setString(2, request.getParameter("gender"));
			statement.setString(3, request.getParameter("email"));
			statement.setString(4, request.getParameter("password"));
			statement.setString(5, request.getParameter("contact"));
			statement.setString(6, request.getParameter("organization"));
			statement.executeUpdate();
			HttpSession session = request.getSession();
			session.setAttribute("email", request.getParameter("email"));
			getServletContext().getRequestDispatcher("/add_vehicle.jsp").include(request, response);
		} catch (SQLException e) {
			PrintWriter out= response.getWriter();
			out.print("<html><body>User already exist<br><a href='log_in.html'>Log In</a></body></html>");
			out.close();
			e.printStackTrace();
		}
	}
}
