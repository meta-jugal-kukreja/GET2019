package question1;

import java.util.List;

/**
 * This class handles the UI part of EmployeeCollections class
 * @author Jugal
 * Dated 08/01/2019
 */
public class Main {

	public static void main(String[] args) {
		
		List<Employee> employeeList;
		EmployeeCollections employeeObject = new EmployeeCollections();
		if(employeeObject.addEmployee(1, "Jugal", "Udaipur"))
		{
			System.out.println("Employee Added");
		}
		if(employeeObject.addEmployee(3, "Aman", "Kanpur"))
		{
			System.out.println("Employee Added");
		}
		if(employeeObject.addEmployee(2, "Babbar", "Jaipur"))
		{
			System.out.println("Employee Added");
		}
		
		System.out.println("\nThe Employees are : (unsorted)");
		employeeList = employeeObject.getEmployeeList();
		Main.printList(employeeList);
		System.out.println("\nEmployees sorted by their id : ");
		employeeList = employeeObject.sortEmployeeById();
		Main.printList(employeeList);
		System.out.println("\nEmployees sorted by their name : ");
		employeeList = employeeObject.sortEmployeeByName();
		Main.printList(employeeList);
	}
	
	/**
	 * This method prints the given list
	 * @param list is the list to be printed
	 */
	static void printList(List<Employee> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("Employee " + (i + 1));
			System.out.println("\tId = " + list.get(i).getEmployeeId());
			System.out.println("\tName = " + list.get(i).getEmployeeName());
			System.out.println("\tAddress = " + list.get(i).getEmployeeAddress());
		}
	}

}
