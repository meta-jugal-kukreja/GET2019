package scf.session3.assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationsTest {
	@Test(expected = AssertionError.class)
	public void maxMirrorTest1() {

		int[] arrayOfNumbers = {};

		ArrOperations operation = new ArrOperations();

		assertEquals(3, operation.lengthOfLargestMirrorSection(arrayOfNumbers));

	}

	@Test
	public void maxMirrorTest2() {

		int[] arrayOfNumbers = { 7, 1, 4, 9, 7, 4, 1 };

		ArrOperations operation = new ArrOperations();

		assertEquals(2, operation.lengthOfLargestMirrorSection(arrayOfNumbers));

	}

	@Test
	public void maxMirrorTest3() {

		int[] arrayOfNumbers = { 1, 4, 5, 3, 5, 4, 1 };

		ArrOperations operation = new ArrOperations();

		assertEquals(7, operation.lengthOfLargestMirrorSection(arrayOfNumbers));

	}

	@Test
	public void maxMirrorTest4() {

		int[] arrayOfNumbers = { 1, 2, 1, 4 };

		ArrOperations operation = new ArrOperations();

		assertEquals(3, operation.lengthOfLargestMirrorSection(arrayOfNumbers));

	}

	@Test
	public void countClumpsTest1() {

		int[] arrayOfNumbers = { 1, 2, 2, 3, 4, 4 };

		ArrOperations operation = new ArrOperations();

		assertEquals(2, operation.calculateNumberOfClumps(arrayOfNumbers));

	}

	@Test(expected = AssertionError.class)
	public void countClumpsTest2() {

		int[] arrayOfNumbers = {};

		ArrOperations operation = new ArrOperations();

		assertEquals(2, operation.calculateNumberOfClumps(arrayOfNumbers));

	}

	@Test
	public void countClumpsTest3() {

		int[] arrayOfNumbers = { 1, 1, 1, 1, 1 };

		ArrOperations operation = new ArrOperations();

		assertEquals(1, operation.calculateNumberOfClumps(arrayOfNumbers));

	}

	@Test
	public void fixXyTest1() {

		int[] arrayOfNumbers = { 5, 4, 9, 4, 9, 5 };
		int[] expected = { 9, 4, 5, 4, 5, 9 };

		ArrOperations operation = new ArrOperations();

		assertArrayEquals(expected, operation.fixXYproblem(arrayOfNumbers, 4, 5));

	}

	@Test(expected = AssertionError.class)
	public void fixXyTest2() {

		int[] arrayOfNumbers = {};
		int[] expected = { 1, 4, 5, 1 };

		ArrOperations operation = new ArrOperations();

		assertArrayEquals(expected, operation.fixXYproblem(arrayOfNumbers, 4, 5));

	}

	@Test
	public void fixXyTest3() {

		int[] arrayOfNumbers = { 1, 4, 1, 5, 5, 4, 1 };

		int[] expected = { 1, 4, 5, 1, 1, 4, 5 };

		ArrOperations operation = new ArrOperations();

		assertArrayEquals(expected, operation.fixXYproblem(arrayOfNumbers, 4, 5));

	}

	@Test
	public void splitArrayTest1() {

		int[] arrayOfNumbers = { 1, 1, 1, 2, 1 };

		ArrOperations operation = new ArrOperations();

		assertEquals(3, operation.splitArray(arrayOfNumbers));

	}

	@Test
	public void splitArrayTest2() {

		int[] arrayOfNumbers = { 2, 1, 1, 2, 1 };

		ArrOperations operation = new ArrOperations();

		assertEquals(-1, operation.splitArray(arrayOfNumbers));

	}

	@Test(expected = AssertionError.class)
	public void splitArrayTest3() {

		int[] arrayOfNumbers = {};

		ArrOperations operation = new ArrOperations();

		assertEquals(1, operation.splitArray(arrayOfNumbers));

	}
}
