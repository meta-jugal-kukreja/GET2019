package question1;

import java.util.Comparator;

/**
 * This class is used to override the compare method in order to perform sorting on the basis employee name
 * @author Jugal
 * Dated 08/22/2019
 */
public class SortOnName implements Comparator<Employee> {

	//Overriding the method
	@Override
	public int compare(Employee employee1, Employee employee2) {
		
		return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
	}

}
