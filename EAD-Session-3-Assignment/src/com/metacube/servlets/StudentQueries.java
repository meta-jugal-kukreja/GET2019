package com.metacube.servlets;

/**
 * This class is used to generate the SQL queris
 * @author Jugal
 * Dated 08/29/2019
 */
public class StudentQueries {
	
	/**
	 * This method generates the insertion query
	 * @param firstName is the first name of the student
	 * @param lastName is the last name of the student
	 * @param fatherName is the father's name of the student
	 * @param email is the email id of the student
	 * @param studentClass is the student class
	 * @param age is the student age
	 * @return {String}
	 */
	static String getInsertionQuery(String firstName, String lastName, String fatherName, String email, int studentClass, int age)
	{
		return "INSERT INTO student_information (first_name, last_name, father_name, email_id, class, age) VALUES (" + 
					"\"" + firstName + "\" , " + "\""  + lastName + "\" , " + "\""  + fatherName + "\" , " + "\""  + email + "\" , " + studentClass + " , " + age + ");";
	}
	
	/**
	 * This method generates the display query
	 * @return {String}
	 */
	static String getDisplayQuery()
	{
		return "SELECT student_id, email_id, first_name, last_name, father_name, class, age FROM student_information";
	}

	/**
	 * This method generates the updation query
	 * @param studentId is the student id
	 * @param firstName is the first name of the student
	 * @param lastName is the last name of the student
	 * @param fatherName is the father's name of the student
	 * @param email is the email id of the student
	 * @param studentClass is the student class
	 * @param age is the student age
	 * @return {String}
	 */
	static String getUpdationQuery(int studentId, String firstName, String lastName, String fatherName, String email, int studentClass, int age)
	{
		return "UPDATE student_information SET first_name = " + "'" +firstName + "', last_name = '" 
						 + lastName + "' , father_name = '"  + fatherName + "' , class = '" + studentClass + "' , age = '" + age + "', email_id = '" + email + "'" 
						 + " WHERE student_id = " + studentId;
	}
	
	/**
	 * This method generates the search query according to name
	 * @param firstName is the first name of the student
	 * @param lastName is the last name of the student
	 * @return {String}
	 */
	static String getSearchQuery(String firstName, String lastName)
	{
		return "SELECT student_id, email_id, first_name, last_name, father_name, class, age FROM student_information "
				+ " WHERE first_name = '" + firstName + "' " + " AND  last_name = '" + lastName + "';";
	}
	
	/**
	 * This method generates the search query according to class
	 * @param studentClass is the class of the student
	 * @return {String}
	 */
	static String getSearchQuery(int studentClass)
	{
		return "SELECT student_id, email_id, first_name, last_name, father_name, class, age FROM student_information "
				+ " WHERE class =  " + studentClass + ";";
	}
	
}
