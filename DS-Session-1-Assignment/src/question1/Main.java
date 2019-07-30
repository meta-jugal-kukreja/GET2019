package question1;

/**
 * This class handles the UI part of the LinkedList class
 * @author Jugal
 * Dated 07/29/2019
 */
public class Main {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();
		
		int[] data1 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,18};
		list.createLinkedList(data1);
		list.generateResultantLinkedList(5, 9, 2);
		list.printList();
		
		int[] data2 = {2,3,4,5,6,7};
		list.createLinkedList(data2);
		list.generateResultantLinkedList(2, 5, 2);
		list.printList();
	}
}
