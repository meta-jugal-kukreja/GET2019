package com.metacube.assignment.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.assignment.classes.MySQLCon;
import com.metacube.assignment.classes.Queries;

/**
 * Servlet implementation class passDetailServlet
 */
@WebServlet("/PassDetailServlet")
public class PassDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat df = new DecimalFormat("##.00");
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForAddPass());
			statement.setString(1, request.getParameter("email"));
			switch (request.getParameter("typeOfCurrency")) {
				case "USD" :
					statement.setString(2, request.getParameter("final_price"));
					break;
				case "INR" :
					double INRprice=0.014*(Double.parseDouble(request.getParameter("final_price")));
					statement.setString(2, df.format(INRprice)+"");
					break;
				case "YEN" :
					double YENprice=0.0094*(Double.parseDouble(request.getParameter("final_price")));
					statement.setString(2, df.format(YENprice)+"");
					break;
			}
			statement.executeUpdate();
			getServletContext().getRequestDispatcher("/home.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
