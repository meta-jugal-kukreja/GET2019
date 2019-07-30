package scf.session3.assignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This class is used to test the FixXY Problem
 * @author Jugal
 *
 */

@RunWith(Parameterized.class)
public class ArrOperationsFixXYTest {

	private int[] inputArray;
	private int[] expectedResult;
	private int x, y;
	private ArrOperations arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperations();
	}

	public ArrOperationsFixXYTest(int[] expectedResult, int[] inputArray, int X, int Y) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.x = X;
		this.y = Y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ new int[] {9, 4, 5, 4, 5, 9}, new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5},
				{ new int[] {1, 4, 5, 1}, new int[] { 1, 4, 1, 5 }, 4, 5 },
				{ new int[] {1, 4, 5, 1, 1, 4, 5}, new int[] { 1, 4, 1, 5, 5, 4, 1}, 4, 5 } ,
				});
	}

	@Test
	public void fixXYTest() {
		assertArrayEquals(expectedResult, arrOperations.fixXYproblem(inputArray, x, y));
	}
}