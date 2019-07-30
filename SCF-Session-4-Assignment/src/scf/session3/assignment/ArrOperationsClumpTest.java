package scf.session3.assignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This class is used to test the Number of Clumps Operation
 * @author Jugal
 *
 */
@RunWith(Parameterized.class)
public class ArrOperationsClumpTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperations arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperations();
	}

	public ArrOperationsClumpTest(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 2, new int[] { 1, 2, 2, 3, 4, 4 } },
				{ 2, new int[] { 1, 1, 2, 1, 1 } },
				{ 1, new int[] { 1, 1, 1, 1, 1} },
				{2, new int[]  {1,1,2,2}},
				{3, new int[] {1,1,2,2,2,1,1}},
				{1, new int[] {2,1,1,1,1,2}}
				});
	}

	@Test
	public void clumpTest() {
		assertEquals(expectedResult, arrOperations.calculateNumberOfClumps(inputArray));
	}
}
