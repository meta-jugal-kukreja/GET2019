package question2;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class contains the test methods for testing methods of class LinkedList
 * @author Jugal
 * Dated 07/30/2019
 */
public class MyLinkedListTest {

	@Test
	public void testDetectLoop1()
	{
		MyLinkedList list = new MyLinkedList();
		int[] data = {2,3,4,5,6,7};
		list.createLinkedList(data);
		assertEquals(false, list.detectLoopInLinkedList());
	}
	@Test
	public void testDetectLoop2()
	{
		MyLinkedList list = new MyLinkedList();
		int[] data = {2,3,4,5,6,7};
		list.createCircularLinkedList(data);
		assertEquals(true, list.detectLoopInLinkedList());
	}
}
