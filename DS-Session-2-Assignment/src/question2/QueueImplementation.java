package question2;

/**
 * This class implements all the methods of the Queue interface
 * @author Jugal
 * Dated 07/31/2019
 */
public class QueueImplementation implements Queue{
	
	int queueSize = 5;
	int[] queue = new int[queueSize];
	int start = -1;
	int end = -1;
	
	/**
	 * This method will add data in the queue in the end
	 *  @param data is the data to be inserted
	 */
	@Override
	public void enqueue(int data) {
		if(isQueueEmpty()) //If queue is empty set start and end to 0
		{
			start = 0;
			end = 0;
		}
		else if(isQueueFull())
		{
			System.out.println("The Queue is full");
		}
		else
		{
			if(end == (queueSize - 1))
				end = 0;
			else
				end++;
		}
		queue[end] = data;
	}

	/**
	 * This method deletes the data from the front
	 */
	@Override
	public void dequeue(){
		if(isQueueEmpty())
		{
			System.out.println("The queue is empty");
		}
		else if(start == end)
		{
			start = -1;
			end = -1;
		}
		else
		{
			if(start == (queueSize - 1))
				start = 0;
			else
				start++;
		}
	}

	/**
	 * This method checks whether the queue is empty
	 *  @return {boolean}
	 */
	@Override
	public boolean isQueueEmpty() {
		if(start == -1)
			return true;
		return false;
	}

	/**
	 * This method checks whether the queue is full
	 *  @return {boolean}
	 */
	@Override
	public boolean isQueueFull() {
		if(((end == (queueSize - 1)) && (start == 0)) || (start == (end + 1)))
			return true;
		return false;
	}

	/**
	 * This method displays the queue
	 */
	@Override
	public void displayQueue() {
		
		if(isQueueEmpty())
		{
			System.out.println("Queue is Empty");
		}
		else
		{
			if(start <= end)
			{
				for(int i = start; i <= end; i++)
				{
					System.out.print(queue[i]  + " ");
				}
			}
			else
			{
				for(int i = start; i <= queueSize - 1; i++)
				{
					System.out.print(queue[i] + " ");
				}
				for(int i = 0; i <= end; i++)
				{
					System.out.print(queue[i] + " ");
				}
			}
		}
	}

}
