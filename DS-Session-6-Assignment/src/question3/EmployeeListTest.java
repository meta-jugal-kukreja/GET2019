package question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods of EmployeeList class
 * @author Jugal
 * Dated 08/12/2019
 */
public class EmployeeListTest {
	
	@Test
	public void test1()
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNodeToList("A", 20, 30000);
		employeeList.addNodeToList("B", 15, 30000);
		employeeList.addNodeToList("C", 40, 40000);
		employeeList.addNodeToList("D", 50, 60000);
		
		employeeList.sortEmployeeList();
		
		assertEquals("D", employeeList.listHead.getEmployeeName());
	}

	@Test
	public void test2()
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNodeToList("A", 22, 30000);
		employeeList.addNodeToList("B", 40, 30000);
		employeeList.addNodeToList("C", 25, 30000);
		employeeList.addNodeToList("D", 22, 10000);
		employeeList.addNodeToList("E", 20, 30000);
		
		employeeList.sortEmployeeList();
		
		assertEquals("E", employeeList.listHead.getEmployeeName());
	}
}
