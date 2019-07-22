package question2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class FCFSTest {

	private FCFS fcfsObject;
	
	//This method creates object before the tests begin
		@Before
		public void initialize() {
			fcfsObject = new FCFS();
		}
		
		//These tests are performed on computeCompletionTime method
		@Test
		public void computeCompletionTimeTest1()
		{
			int[][] processes = {{0,10},{6,10}};
			List<Integer> completionTimeList = new ArrayList<>();
			completionTimeList = fcfsObject.computeCompletionTime(processes);
			assertEquals(10, (int)completionTimeList.get(0));
		}
		@Test
		public void computeCompletionTimeTest2()
		{
			int[][] processes = {{0,10},{6,10}};
			List<Integer> completionTimeList = new ArrayList<>();
			completionTimeList = fcfsObject.computeCompletionTime(processes);
			assertEquals(20, (int)completionTimeList.get(1));
		}
		
		//These tests are performed on computeCompletionTime method
				@Test
				public void computeTurnAroundTimeTest1()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					assertEquals(10, (int)turnAroundTimeList.get(0));
				}
				@Test
				public void computeTurnAroundTimeTest2()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					assertEquals(14, (int)turnAroundTimeList.get(1));
				}
				
				//These tests are performed on computeWaitingTime method
				@Test
				public void computeWaitingTimeTest1()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					List<Integer> waitingTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					waitingTimeList = fcfsObject.computeWaitingTime(processes, turnAroundTimeList);
					assertEquals(0, (int)waitingTimeList.get(0));
				}
				@Test
				public void computeWaitingTimeTest2()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					List<Integer> waitingTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					waitingTimeList = fcfsObject.computeWaitingTime(processes, turnAroundTimeList);
					assertEquals(4, (int)waitingTimeList.get(1));
				}
				
				//These tests are performed on computeMaximumWaitingTime method
				@Test
				public void computeMaximumWaitingTimeTest1()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					List<Integer> waitingTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					waitingTimeList = fcfsObject.computeWaitingTime(processes, turnAroundTimeList);
					assertEquals(4, fcfsObject.computeMaximumWaitingTime(waitingTimeList));
				}
				
				//These tests are performed on computeAverageWaitingTime method
				@Test
				public void computeAverageWaitingTimeTest1()
				{
					int[][] processes = {{0,10},{6,10}};
					List<Integer> completionTimeList = new ArrayList<>();
					List<Integer> turnAroundTimeList = new ArrayList<>();
					List<Integer> waitingTimeList = new ArrayList<>();
					completionTimeList = fcfsObject.computeCompletionTime(processes);
					turnAroundTimeList = fcfsObject.computeTurnAroundTime(processes, completionTimeList);
					waitingTimeList = fcfsObject.computeWaitingTime(processes, turnAroundTimeList);
					assertEquals(2.0, (double)fcfsObject.computeAverageWaitingTime(waitingTimeList), (double)0.0);
				}
}


