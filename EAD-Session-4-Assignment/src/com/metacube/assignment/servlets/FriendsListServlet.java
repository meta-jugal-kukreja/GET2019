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
import com.metacube.assignment.classes.Queries;

/**
 * Servlet implementation class FriendsListServlet
 */
@WebServlet("/FriendsListServlet")
public class FriendsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForFriendsList());
			statement.setString(1, request.getParameter("email"));
			statement.setString(2, request.getParameter("email"));
			ResultSet resultSet = statement.executeQuery();
	        request.setAttribute("friendList", resultSet);
	        getServletContext().getRequestDispatcher("/friend_list.jsp").include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
