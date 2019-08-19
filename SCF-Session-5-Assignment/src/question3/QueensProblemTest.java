package question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods of QueensProblem class
 * @author Jugal
 * Dated 07/18/2019
 */
public class QueensProblemTest {

	//These are the test methods for testing Queens Problem
	@Test
	public void testQueensProblem1()
	{
		int[][] board = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int dimension = 4;
		QueensProblem problemObject = new QueensProblem(dimension);
		assertEquals(true, problemObject.startNQueensProblem(board, 0));
	}
	@Test(expected = AssertionError.class) //Negative test
	public void testQueensProblem2()
	{
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int dimension = 3;
		QueensProblem problemObject = new QueensProblem(dimension);
		assertEquals(true, problemObject.startNQueensProblem(board, 0));
	}
	@Test(expected = AssertionError.class)//Negative test
	public void testQueensProblem3()
	{
		int[][] board = {};
		int dimension = 4;
		QueensProblem problemObject = new QueensProblem(dimension);
		assertEquals(true, problemObject.startNQueensProblem(board, 0));
	}
}
