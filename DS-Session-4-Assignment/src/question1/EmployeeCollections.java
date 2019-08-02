package question1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollections {
	
	private List<Employee> employeeList;
	
	public EmployeeCollections() {
		employeeList = new ArrayList<>();
	}

	List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	/**
	 * This method adds an employee to the employee list given it satisfies some conditions
	 * @param employeeId is Id of the employee to be added
	 * @param employeeName is Name of the employee to be added
	 * @param employeeAddress is Address of the employee to be added
	 * @return {boolean}
	 */
	boolean addEmployee(int employeeId, String employeeName, String employeeAddress)
	{
		boolean wasEmployeeAdded = false;
		if((employeeId > 0) && isEmployeeUnique(employeeId) && isEmployeeNameValid(employeeName) && employeeAddress != null)
		{
			Employee employee = new Employee(employeeId, employeeName, employeeAddress);
			employeeList.add(employee);
			wasEmployeeAdded = true;
		}
		else
		{
			throw new AssertionError();
		}
		return wasEmployeeAdded;
	}
	
	/**
	 * This method sorts the employees in ascending order according to their employee id
	 * @return {List<Employee>} sort employee list
	 */
	List<Employee> sortEmployeeById()
	{
		Employee temporaryEmployee;
		int i,j;
		for(i = 0; i < employeeList.size(); i++)
		{
			for(j = 0; j < employeeList.size() - i - 1; j++)
			{
				if(employeeList.get(j).getEmployeeId() > employeeList.get(j+1).getEmployeeId())
				{
					temporaryEmployee = employeeList.get(j);
					employeeList.set(j, employeeList.get(j+1));
					employeeList.set(j+1, temporaryEmployee);
				}
			}
		}
		return employeeList;
	}
	
	/**
	 * This method sorts the employees in ascending order according to their name
	 * @return {List<Employee>} sort employee list
	 */
	List<Employee> sortEmployeeByName()
	{
		Employee temporaryEmployee;
		int i,j;
		for(i = 0; i < employeeList.size(); i++)
		{
			for(j = 0; j < employeeList.size() - i - 1; j++)
			{
				if(employeeList.get(j).getEmployeeName().compareTo(employeeList.get(j+1).getEmployeeName()) > 0)
				{
					temporaryEmployee = employeeList.get(j);
					employeeList.set(j, employeeList.get(j+1));
					employeeList.set(j+1, temporaryEmployee);
				}
			}
		}
		return employeeList;
	}
	/**
	 * This method checks whether an employee is unique by checking its employee id
	 * @param employeeId is the employee Id of the employee to be checked
	 * @return {boolean}
	 */
	boolean isEmployeeUnique(int employeeId)
	{
		boolean answer = true;
		for(Employee employee :  employeeList)
		{
			if(employee.getEmployeeId() == employeeId)
			{
				answer = false;
			}
		}
		return answer;
	}

	/**
	 * This method checks whether an employee name is valid
	 * @param employeeName is the employee Name of the employee to be validated
	 * @return {boolean}
	 */
	boolean isEmployeeNameValid(String employeeName)
	{
		boolean isValid = true;
		for(int i = 0; i < employeeName.length(); i++)
		{
			if(!(((employeeName.charAt(i) >= 'A') && (employeeName.charAt(i) <= 'Z')) || ((employeeName.charAt(i) >= 'a') && (employeeName.charAt(i) <= 'z'))))
			{
				isValid = false;
			}
		}
		return isValid;
	}
}
