package question2;

/**
 * This class represents a job which has a value and a priority
 * @author Jugal
 * Dated 08/02/2019
 */
public class Job {
	
	private String jobName;
	private int priority;
	
	Job(String jobName, int priority)
	{
		this.jobName = jobName;
		this.priority = priority;
	}

	public String getJobName() {
		return jobName;
	}

	public int getPriority() {
		return priority;
	}
}
