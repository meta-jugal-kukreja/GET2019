package com.metacube.assignment.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.assignment.classes.MySQLCon;
import com.metacube.assignment.classes.Queries;


/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForAddVehicle());
			statement.setString(1, request.getParameter("vehicle_name"));
			statement.setString(2, request.getParameter("typeOfVehicle"));
			statement.setString(3, request.getParameter("vehicleNumber"));
			statement.setString(4, request.getParameter("email"));
			statement.setString(5, request.getParameter("vehicleIdentification"));
			statement.executeUpdate();
			request.setAttribute("vehicleType", request.getParameter("typeOfVehicle"));
			getServletContext().getRequestDispatcher("/pass_detail.jsp").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
