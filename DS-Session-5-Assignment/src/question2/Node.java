package question2;
/**
 * This class represents a node in a linked list
 * @author Jugal
 *
 */
public class Node {

	int employeeId;
	int employeeAge;
	String employeeName;
	Node next;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param data
	 */
	public Node(int employeeId, int employeeAge ,String employeeName)
	{
		this.employeeId = employeeId;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.next = null;
	}
}
