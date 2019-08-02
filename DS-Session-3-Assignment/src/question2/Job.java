package question2;

/**
 * This class represents a job which has a value and a priority
 * @author Jugal
 * Dated 08/02/2019
 */
public class Job {
	
	private int value;
	private int priority;
	
	Job(int value, int priority)
	{
		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
}
