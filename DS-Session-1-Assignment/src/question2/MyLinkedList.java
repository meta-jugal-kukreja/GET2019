package question2;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

	Node linkedListHead;
	Node linkedListTail;

	/**
	 * Constructor to initialize an empty list
	 */
	 MyLinkedList() {
		linkedListHead = null;
		linkedListTail = null;
	}

	/**
	 * This method creates a singly linked list
	 * 
	 * @param dataArray is the array containing data part of the node
	 */
	 void createLinkedList(int[] dataArray) {
		 
		for (int i = 0; i < dataArray.length; i++) {
			
			Node newNode = new Node(dataArray[i]);
			
			if (linkedListHead == null) {
				linkedListHead = newNode;
				linkedListTail = newNode;
			} 
			else {
				linkedListTail.next = newNode;
				linkedListTail = newNode;
			}
		}
	}
	
	/**
	 * This method creates a Circular linked list
	 * 
	 * @param dataArray is the array containing data part of the node
	 */
	 void createCircularLinkedList(int[] dataArray) {
		 
		for (int i = 0; i < dataArray.length; i++) {
			Node newNode = new Node(dataArray[i]);
			if (linkedListHead == null) {
				linkedListHead = newNode;
				linkedListTail = newNode;
			} else {
				linkedListTail.next = newNode;
				linkedListTail = newNode;
			}
		}
		linkedListTail.next = linkedListHead;
	}

	 /**
	  * This method detects loop in the linked list
	  * @return {boolean}
	  */
	boolean detectLoopInLinkedList()
	{
		boolean answer = false;
		List<Node> nodeAddresses = new ArrayList<>();
		Node temporaryNode = linkedListHead;
		
		while(temporaryNode != null)
		{
			if(nodeAddresses.contains(temporaryNode))
			{
				answer = true;
				break;
			}
			else
				nodeAddresses.add(temporaryNode);
			
			temporaryNode = temporaryNode.next;
		}
		
		return answer;
	}
}

