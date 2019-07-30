package question1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains the test methods for testing methods of class LinkedList
 * @author Jugal
 * Dated 07/30/2019
 */
public class MyLinkedListTest {

	@Test
	public void testRotation1()
	{
		int[] data = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,18};
		MyLinkedList list = new MyLinkedList();
		list.createLinkedList(data);
		list.generateResultantLinkedList(5, 9, 2);
		int[] captureData = new int[data.length];
		Node temporaryNode = list.linkedListHead;
		int i = 0;
		while(temporaryNode != null)
		{
			captureData[i] = temporaryNode.data;
			temporaryNode = temporaryNode.next;
			i++;
		}
		int[] expectedData = {2,3,4,5,8,9,10,6,7,11,12,13,14,15,18};
		
		assertArrayEquals(expectedData, captureData);
	}
	@Test
	public void testRotation2()
	{
		int[] data = {2,3,4,5,6,7};
		MyLinkedList list = new MyLinkedList();
		list.createLinkedList(data);
		list.generateResultantLinkedList(2, 5, 2);
		int[] captureData = new int[data.length];
		Node temporaryNode = list.linkedListHead;
		int i = 0;
		while(temporaryNode != null)
		{
			captureData[i] = temporaryNode.data;
			temporaryNode = temporaryNode.next;
			i++;
		}
		int[] expectedData = {2,5,6,3,4,7};
		
		assertArrayEquals(expectedData, captureData);
	}

}
