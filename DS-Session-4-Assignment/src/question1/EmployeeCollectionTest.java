package question1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * This class tests the methods of EmployeeCollections class
 * @author Jugal
 * Dated 08/01/2019
 */
public class EmployeeCollectionTest {
	
	@Test
	public void testSortById()
	{
		List<Employee> employeeList;
		EmployeeCollections employeeObject = new EmployeeCollections();
		employeeObject.addEmployee(1, "Jugal", "Udaipur");
		employeeObject.addEmployee(3, "Aman", "Kanpur");
		employeeObject.addEmployee(2, "Babbar", "Jaipur");
		employeeList = employeeObject.sortEmployeeById();
		
		assertEquals("Jugal", employeeList.get(0).getEmployeeName());
		assertEquals("Babbar", employeeList.get(1).getEmployeeName());
	}
	
	@Test
	public void testSortByName1()
	{
		List<Employee> employeeList;
		EmployeeCollections employeeObject = new EmployeeCollections();
		employeeObject.addEmployee(1, "Jugal", "Udaipur");
		employeeObject.addEmployee(3, "Aman", "Kanpur");
		employeeObject.addEmployee(2, "Babbar", "Jaipur");
		employeeList = employeeObject.sortEmployeeByName();
		
		assertEquals("Aman", employeeList.get(0).getEmployeeName());
		assertEquals("Babbar", employeeList.get(1).getEmployeeName());
	}

	@Test(expected = AssertionError.class)
	public void testSortByName2()
	{
		List<Employee> employeeList;
		EmployeeCollections employeeObject = new EmployeeCollections();
		employeeObject.addEmployee(1, "Jugal", "Udaipur");
		employeeObject.addEmployee(1, "Aman", "Kanpur");
		employeeObject.addEmployee(2, "Babbar", "Jaipur");
		employeeList = employeeObject.sortEmployeeByName();
		
		assertEquals("Aman", employeeList.get(0).getEmployeeName());
		assertEquals("Babbar", employeeList.get(1).getEmployeeName());
	}
}
