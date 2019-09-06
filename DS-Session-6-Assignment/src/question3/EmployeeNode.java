package question3;

/**
 * This class represents a node in the doubly linked list
 * @author Jugal
 * Dated 08/12/2019
 */
public class EmployeeNode {
	
	private String employeeName; 
	private int employeeAge;
	private double employeeSalary;
    EmployeeNode nextNode; 
      
    /**
     * Constructor to initialize the data members of the class
     * @param employeeName is the employee name
     * @param employeeAge is the employee age
     * @param employeeSalary is the employee salary
     */
    EmployeeNode(String employeeName, int employeeAge, double employeeSalary)
    {
    	this.employeeName = employeeName;
    	this.employeeAge = employeeAge;
    	this.employeeSalary = employeeSalary;
    }

    //Getter methods
	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public EmployeeNode getNextNode() {
		return nextNode;
	}

	/**
	 * This method sets the employee data
	 * @param employeeName is the employee name
     * @param employeeAge is the employee age
     * @param employeeSalary is the employee salary
	 */
	void setEmployeeData(String employeeName, int employeeAge, double employeeSalary)
	{
		this.employeeName = employeeName;
    	this.employeeAge = employeeAge;
    	this.employeeSalary = employeeSalary;
	}
}
