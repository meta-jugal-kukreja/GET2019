package question3;

/**
 * This class overrides the methods to implement the queue
 * @author Jugal
 * Dated 07/31/2019
 */
public class StudentQueue implements Queue<Student> {

	private int start; // front element of the queue
	private int end; // rear element of the queue
	private int size; // maximum size of the array
	private Student[] queue;
	
	public StudentQueue() {
		
		start = -1;
		end = -1;
		this.size = 10;
		queue = new Student[size];
	}
	
	/**
	 * This method adds data in the queue
	 */
	@Override
	public void enqueue(Student data) throws Exception {
		
		if (start == -1) {
			start++;
			end++;
		} else if (!isQueueFull()) {
			end++;
		} else {
			throw new AssertionError(
					"Queue overflow: cannot insert more elements");
		}
		queue[end] = data;
	}

	/**
	 * This method deletes data in the queue
	 * @return {Student} deleted data
	 */
	@Override
	public Student dequeue() throws Exception {
		Student data = null;
		if (!isQueueEmpty()) {
			data = queue[start];
			start++;
		} else {
			throw new AssertionError(
					"Queue Underflow: no element is present in the queue");
		}
		return data;
	}

	/**
	 * This method checks if the queue is empty
	 */
	@Override
	public boolean isQueueEmpty() {
		if(start == end+1)
			return true;
		return false;
	}

	/**
	 * This method checks if the queue is full
	 */
	@Override
	public boolean isQueueFull() {
		if(end == (queue.length - 1))
			return true;
		return false;
	}

	/**
	 * This method displays the student queue
	 */
	@Override
	public void displayQueue() throws Exception {
		
		for(int i = start; i <= end; i++)
		{
			System.out.println(queue[i].getName()  + " ");
			String[] subjects = queue[i].getPreferredPrograms();
			for(int j = 0; j < subjects.length; j++)
				System.out.println("\t" + subjects[j]);
		}
	}

}
