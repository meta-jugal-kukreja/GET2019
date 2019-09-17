package com.metacube.assignment.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.assignment.classes.MySQLCon;
import com.metacube.assignment.classes.Queries;;

/**
 * Servlet implementation class FriendDetailServlet
 */
@WebServlet("/FriendDetailServlet")
public class FriendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForEmpDetail());
			statement.setString(1, request.getParameter("email"));
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			request.setAttribute("emp_name", resultSet.getString(1));
			request.setAttribute("gender", resultSet.getString(2));
			request.setAttribute("email", resultSet.getString(3));
			request.setAttribute("contact_number", resultSet.getString(4));
			request.setAttribute("organization", resultSet.getString(5));
			request.setAttribute("vehicle_name", resultSet.getString(6));
			request.setAttribute("vehicle_type", resultSet.getString(7));
			request.setAttribute("vehicle_number", resultSet.getString(8));
			request.setAttribute("identification", resultSet.getString(9));
			request.setAttribute("pass_number", resultSet.getInt(10));
			request.setAttribute("price", resultSet.getDouble(11));
			getServletContext().getRequestDispatcher("/user_detail.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
