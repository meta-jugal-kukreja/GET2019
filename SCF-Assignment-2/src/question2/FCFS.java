package question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains all the methods to perform all operations.
 * @author Admin
 * Dated 07/11/2019
 */
public class FCFS {
	// Variables for accessing columns of the 2D array.
	private static final int COLUMN_FIRST = 0;
	private static final int COLUMN_SECOND = 1;

	/**
	 * This method computes Completion Time of each process
	 * 
	 * @param processes
	 *            contains arrival and burst time of each process
	 * @return {List}List of Completion time of each process
	 */
	public ArrayList<Integer> computeCompletionTime(int[][] processes) {
		int i;
		ArrayList<Integer> completionTimeList = new ArrayList<>();
		int completionTime = (processes[COLUMN_FIRST][COLUMN_FIRST] + processes[COLUMN_FIRST][COLUMN_SECOND]);
		completionTimeList.add(completionTime);
		for (i = 1; i < processes.length; i++) {

			if (processes[i][COLUMN_FIRST] < completionTime) {
				completionTime = completionTime + processes[i][COLUMN_SECOND];
			} else {
				completionTime = processes[i][COLUMN_FIRST]
						+ processes[i][COLUMN_SECOND];
			}
			completionTimeList.add(completionTime);
		}
		return completionTimeList;
	}

	/**
	 * This method computes Maximum Waiting Time in all processes
	 * 
	 * @param waitingTimeList
	 *            contains waiting times of all processes
	 * @return {int}Maximum Waiting time
	 */
	public int computeMaximumWaitingTime(List<Integer> waitingTimeList) {
		int maxWaitingTime = waitingTimeList.get(0);
		for (int i = 1; i < waitingTimeList.size(); i++) {
			int eachTime = waitingTimeList.get(i);
			if (maxWaitingTime < eachTime)
				maxWaitingTime = eachTime;
		}
		return maxWaitingTime;
	}

	/**
	 * This method computes Turn around Time of each process
	 * 
	 * @param processes
	 *            contains arrival and burst time of each process
	 * @param completionTimeList
	 *            contains Completion times of all processes
	 * @return {List}List of Completion time of each process
	 */
	public ArrayList<Integer> computeTurnAroundTime(int[][] processes,
			List<Integer> completionTimeList) {
		int i;
		ArrayList<Integer> turnAroundTimeList = new ArrayList<>();
		for (i = 0; i < processes.length; i++) {
			turnAroundTimeList.add(completionTimeList.get(i)
					- processes[i][COLUMN_FIRST]);
		}
		return turnAroundTimeList;
	}

	/**
	 * This method computes Average Waiting Time of all process
	 * 
	 * @param waitingTimeList
	 *            contains waiting times of all processes
	 * @return {double}Average Waiting Time
	 */
	public double computeAverageWaitingTime(List<Integer> waitingTimeList) {
		int totalWaitingTime = 0;
		for (int i = 0; i < waitingTimeList.size(); i++)
			totalWaitingTime += waitingTimeList.get(i);
		return (totalWaitingTime / waitingTimeList.size());
	}

	/**
	 * This method computes Waiting Time of each process
	 * 
	 * @param processes
	 *            contains arrival and burst time of each process
	 * @param turnAroundTimeList
	 *            contains Turn around times of all processes
	 * @return {List}List of Completion time of each process
	 */
	public ArrayList<Integer> computeWaitingTime(int[][] processes,
			List<Integer> turnAroundTimeList) {
		int i;
		ArrayList<Integer> waitingTimeList = new ArrayList<>();
		for (i = 0; i < processes.length; i++) {
			waitingTimeList.add(turnAroundTimeList.get(i)
					- processes[i][COLUMN_SECOND]);
		}
		return waitingTimeList;
	}

}
