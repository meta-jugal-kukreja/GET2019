package question2;

/**
 * This class handles the UI part of the LinkedList class
 * @author Jugal
 * Dated 07/29/2019
 */
public class Main {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();
		
		int[] data = {2,3,4,5,6,7};
		list.createLinkedList(data);
		System.out.println(list.detectLoopInLinkedList());
		
		int[] data1 = {2,3,4,5,6,7};
		list.createCircularLinkedList(data1);
		System.out.println(list.detectLoopInLinkedList());
	}
}
