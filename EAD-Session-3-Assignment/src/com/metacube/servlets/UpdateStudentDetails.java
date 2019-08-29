package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentDetails
 */
@WebServlet("/UpdateStudentDetails")
public class UpdateStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Update Student Details</title></head><body align='center'><h2> Update student Details</h2>" + 
							"<form action='UpdateDetails' method='GET' >" + 
							"<table align='center'>" + 
							"<tr><td><span>Student Id : </span></td>" + 
							"<td> <input type='text' name='s_id' value='" + request.getParameter("studentId") + "' readonly></td></tr>" + 
							"<tr><td><span>First Name : </span></td>" + 
							"<td> <input type='text' name='s_first_name' value='" + request.getParameter("firstName") +"'></td></tr>" + 
							"<tr><td> <span>Last Name : </span></td>" + 
							"<td><input type='text' name='s_last_name' value='" + request.getParameter("lastName") + "'></td></tr>" +
							"<tr><td><span>Father's Name : </span></td>" + 
							"<td><input type='text' name='s_father_name' value='" + request.getParameter("fatherName") +"'></td></tr>" + 
							"<tr><td><span>Email Id : </span></td>" + 
							"<td><input type='text' name='s_email' value='"+ request.getParameter("email") + "' ></td></tr>" + 
							"<tr><td><span>Class : </span></td>" + 
							"<td><input type='text' name='s_class' value='" + request.getParameter("class") + "'></td></tr>" + 
							"<tr><td><span>Age : </span></td>" + 
							"<td><input type='text' name='s_age' value='" + request.getParameter("age") + "'></td></tr>" +
							"</table>" + 
							"<br /><input type='submit' name='s_submit_button' value='Submit'>" + 
							"</form>" + 
							"</body></html>");

	}

}
