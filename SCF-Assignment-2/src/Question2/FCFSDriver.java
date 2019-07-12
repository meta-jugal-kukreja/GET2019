package Question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FCFSDriver {

	public static void main(String[] args) {

		System.out.print("Enter the number of processes : ");

		Scanner inputScanner = new Scanner(System.in);

		int numberOfProcess = inputScanner.nextInt();
		
		//Lists for storing all the times.
		List<Integer> completionTimeList = new ArrayList<>();
		List<Integer> turnAroundTimeList = new ArrayList<>();
		List<Integer> waitingTimeList = new ArrayList<>();

		int NUMBER_OF_COLUMNS = 2;

		int[][] processes = new int[numberOfProcess][NUMBER_OF_COLUMNS];

		for (int i = 0; i < numberOfProcess; i++) {
			System.out.print("Enter Arrival time and Burst Time of process "
					+ (i + 1) + " (Space Separated): ");
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				processes[i][j] = inputScanner.nextInt();
			}
		}

		FCFS fcfs = new FCFS();
		//Calling all the functions
		completionTimeList = fcfs.computeCompletionTime(processes);
		turnAroundTimeList = fcfs.computeTurnAroundTime(processes,
				completionTimeList);
		waitingTimeList = fcfs
				.computeWaitingTime(processes, turnAroundTimeList);
		
		//Printing all the values
		for (int i = 0; i < completionTimeList.size(); i++) {
			System.out.print("\nCompletion time of process " + (i + 1) + " : "
					+ completionTimeList.get(i));
			System.out.print("\nTurn Around time of process " + (i + 1) + " : "
					+ turnAroundTimeList.get(i));
			System.out.println("\nBurst time of process " + (i + 1) + " : "
					+ waitingTimeList.get(i));
		}
		System.out.println("\nAverage Waiting time of processes : "
				+ fcfs.computeAverageWaitingTime(waitingTimeList));
		System.out.println("\nMaximum Waiting time of processes : "
				+ fcfs.computeMaximumWaitingTime(waitingTimeList));

	}

}
