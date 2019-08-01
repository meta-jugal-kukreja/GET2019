package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods of Queue interface
 * @author Jugal
 * Dated 07/31/2019
 */
public class QueueImplementationTest {
	
	@Test
	public void testQueueStatus1() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.enqueue(1);
		queue.enqueue(2);
		
		assertEquals(false, queue.isQueueEmpty());
		assertEquals(false, queue.isQueueFull());
	}
	
	@Test
	public void testQueueStatus2() throws Exception
	{
		Queue queue = new QueueImplementation();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		
		assertEquals(true, queue.isQueueEmpty());
		assertEquals(false, queue.isQueueFull());
	}	
	
	@Test(expected = Exception.class)
	public void testQueueStatus3() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
	}
	
	@Test(expected = Exception.class)
	public void testQueueStatus4() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.dequeue();
	}

}
