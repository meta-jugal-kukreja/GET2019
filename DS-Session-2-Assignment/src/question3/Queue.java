package question3;

/**
 * This interface represents the operations which are to be performed on a queue
 * @author Jugal
 * Dated 07/31/2019
 */
public interface Queue<Student> {
	
	//Method for inserting data in the queue
	public void enqueue(Student data) throws Exception;
	
	//Method for deleting data from the queue
	public Student dequeue() throws Exception;
	
	//Method for checking if the queue is empty
	public boolean isQueueEmpty();
	
	//Method for checking whether the queue is full
	public boolean isQueueFull();
	
	//Method displays the queue
	public void displayQueue() throws Exception;

}
