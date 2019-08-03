package question2;

public class EmployeeList {
	
	Node linkedListHead;
	Node linkedListTail;
	
	/**
	 * Constructor to initialize an empty list
	 */
	public EmployeeList()
	{
		linkedListHead = null;
		linkedListTail = null;
	}

	/**
	 * This method adds a node in the linked list
	 * @param employeeId is the data part of the node
	 */
	public void addNode(int employeeId, int employeeAge, String employeeName) {       
        Node newNode = new Node(employeeId, employeeAge, employeeName);    
        
        if(linkedListHead == null) {    
        	linkedListHead = newNode;    
        	linkedListTail = newNode;    
        }    
        else {    
        	linkedListTail.next = newNode;    
        	linkedListTail = newNode;    
        }    
    }
	
	void sortEmployeeList()
	{
		
	}
	
	/**
	 * This method prints the linked list
	 */
	public void printList()
	{
		Node temporaryNode = linkedListHead;
		int i = 1;
		while(temporaryNode != null)
		{
			System.out.println("Employee : " + i);
			System.out.println("\t" + temporaryNode.employeeId + "\t" + temporaryNode.employeeName);
			temporaryNode = temporaryNode.next;
			i++;
		}
	}
}
