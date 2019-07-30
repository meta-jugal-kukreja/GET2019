package question1;


public class MyLinkedList {
	
	Node linkedListHead;
	Node linkedListTail;
	
	/**
	 * Constructor to initialize an empty list
	 */
	public MyLinkedList()
	{
		linkedListHead = null;
		linkedListTail = null;
	}

	/**
	 * This methods creates a linked list
	 * @param dataArray contains the elements through which linked list is to be created
	 */
	public void createLinkedList(int[] dataArray)
	{
		for(int i = 0; i < dataArray.length; i++)
		{
			addNode(dataArray[i]);
		}
	}
	
	/**
	 * This method adds a node in the linked list
	 * @param data is the data part of the node
	 */
	public void addNode(int data) {       
        Node newNode = new Node(data);    
        
        if(linkedListHead == null) {    
        	linkedListHead = newNode;    
        	linkedListTail = newNode;    
        }    
        else {    
        	linkedListTail.next = newNode;    
        	linkedListTail = newNode;    
        }    
    }
	
	/**
	 * This method generates a sub list which is to be rotated
	 * @param L is the left position
	 * @param R is the right position
	 * @param N is number of steps through which the linked list is to be rotated
	 */
	public void generateResultantLinkedList(int L, int R, int N)
	{
		int leftCount = 1;
		Node subListHead = null;
		Node temporaryNode = linkedListHead;
		while(leftCount != L-1)
		{
			temporaryNode = temporaryNode.next;
			leftCount++;
		}
		Node leftNode = temporaryNode;
		subListHead = temporaryNode.next;
		
		Node subListTail = subListHead;
		int rightCount = L;
		while(rightCount != R)
		{
			subListTail = subListTail.next;
			rightCount++;
		}
		modifySubList(leftNode, subListHead, subListTail, N);
	}
	
	/**
	 * This method rotates the sublist by some steps
	 * @param leftNode is the node predecessor to the first nod in the sub list
	 * @param head is the starting address of the sub list
	 * @param tail is the ending address of the sub list
	 * @param N is the number of steps to which the list is to be rotated
	 */
	public void modifySubList(Node leftNode, Node head, Node tail, int N)
	{
		Node temporaryNode = head;
		int count = 1;
		while(count != N)
		{
			temporaryNode = temporaryNode.next;
			count++;
		}
		Node NthNode = temporaryNode;
		while(temporaryNode != tail)
		{
			temporaryNode = temporaryNode.next;
		}
		
		leftNode.next = NthNode.next;
		NthNode.next = tail.next;
		temporaryNode.next = head;

	}
	
	/**
	 * This method prints the linked list
	 */
	public void printList()
	{
		Node temporaryNode = linkedListHead;
		while(temporaryNode != null)
		{
			System.out.println(temporaryNode.data);
			temporaryNode = temporaryNode.next;
		}
	}
}
