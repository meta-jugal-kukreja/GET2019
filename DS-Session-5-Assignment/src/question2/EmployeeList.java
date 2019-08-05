package question2;

public class EmployeeList {
	
	Node linkedListHead;
	Node linkedListTail;
	
	Node sortedLinkedListHead; //Head for sorted linked list
	
	/**
	 * Constructor to initialize an empty list
	 */
	public EmployeeList()
	{
		linkedListHead = null;
		linkedListTail = null;
		sortedLinkedListHead = null;
	}

	/**
	 * This method adds a node in the linked list
	 * @param employeeId is the data part of the node
	 */
	public void addNode(double employeeSalary, int employeeAge, String employeeName) {       
        Node newNode = new Node(employeeSalary, employeeAge, employeeName);    
        
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
		Node currentNode = linkedListHead;
		
		while(currentNode != null)
		{
			Node nextNode = currentNode.next;
			applyInsertionSort(currentNode);
			currentNode = nextNode;
		}
	}
	
	void applyInsertionSort(Node node) {
		
		if(sortedLinkedListHead == null)
		{
			node.next = sortedLinkedListHead;
			sortedLinkedListHead = node;
		}
		else
		{
			Node temporaryNode = sortedLinkedListHead;
			while(temporaryNode != null)
			{
				if((temporaryNode.getEmployeeSalaray() > node.getEmployeeSalaray()) || 
						(temporaryNode.getEmployeeSalaray() == node.getEmployeeSalaray()))
				{
					if(temporaryNode.getEmployeeSalaray() > node.getEmployeeSalaray())
					{
						temporaryNode = temporaryNode.next;
					}
					else if((temporaryNode.getEmployeeSalaray() == node.getEmployeeSalaray()) && 
							(temporaryNode.getEmployeeAge() < node.getEmployeeAge())) 
					{
						temporaryNode = temporaryNode.next;
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
			node.next = temporaryNode.next;
			temporaryNode.next = node;
			System.out.println("List after operation");
			printList(sortedLinkedListHead);
		}
	}

	/**
	 * This method prints the linked list
	 */
	public void printList(Node head)
	{
		Node temporaryNode = head;
		int i = 1;
		while(temporaryNode != null)
		{
			System.out.print("Employee : " + i);
			System.out.print("\t " + temporaryNode.getEmployeeSalaray() + "\t" + temporaryNode.getEmployeeName());
			temporaryNode = temporaryNode.next;
			i++;
			System.out.println();
		}
	}
}
