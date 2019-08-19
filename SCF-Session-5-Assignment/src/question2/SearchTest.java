package question2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This class is used to test the Search Class
 * @author Jugal
 *
 */
public class SearchTest {

	private Search searchObject;

	//This method creates object before the tests begin
	@Before
	public void initialize() {
		searchObject = new Search();
	}

	//These tests are performed on binary search
	@Test
	public void binarySearchTest1() {
		int[] inputArray = { 1, 2, 3, 4, 5, 6};
		int elementToBeSearched = 4;
		int start = 0;
		assertEquals(3, searchObject.binarySearch(inputArray, elementToBeSearched, start, inputArray.length - 1));
	}
	@Test
	public void binarySearchTest2() {
		int[] inputArray = { 6, 5, 4, 3, 2, 1};
		int elementToBeSearched = 4;
		int start = 0;
		assertEquals(2, searchObject.binarySearch(inputArray, elementToBeSearched, start, inputArray.length - 1));
	}
	@Test
	public void binarySearchTest3() {
		int[] inputArray = { 1, 3, 5, 7, 9};
		int elementToBeSearched = 7;
		int start = 0;
		assertEquals(3, searchObject.binarySearch(inputArray, elementToBeSearched, start, inputArray.length - 1));
	}
	@Test
	public void binarySearchTest4() {
		int[] inputArray = { 1, 3, 5, 7, 9};
		int elementToBeSearched = 10;
		int start = 0;
		assertEquals(-1, searchObject.binarySearch(inputArray, elementToBeSearched, start, inputArray.length - 1));
	}
	
	/*
	 * These tests are performed on linear search
	 */
	@Test
	public void linearSearch1() {
		int[] inputArray = { 1, 5, 8, 4, 10, 3};
		int elementToBeSearched = 4;
		int start = 0;
		assertEquals(3, searchObject.linearSearch(inputArray, elementToBeSearched, 0));
	}
	@Test
	public void linearSearch2() {
		int[] inputArray = { 3, 1, 4, 8, 6, 9};
		int elementToBeSearched = 4;
		int start = 0;
		assertEquals(2, searchObject.linearSearch(inputArray, elementToBeSearched, 0));
	}
	@Test
	public void linearSearch3() {
		int[] inputArray = { 1, 8, 3, 7, 6, 2};
		int elementToBeSearched = 7;
		int start = 0;
		assertEquals(3, searchObject.linearSearch(inputArray, elementToBeSearched, 0));
	}
	@Test
	public void linearSearch4() {
		int[] inputArray = { 1, 8, 3, 7, 6, 2};
		int elementToBeSearched = 10;
		int start = 0;
		assertEquals(-1, searchObject.linearSearch(inputArray, elementToBeSearched, 0));
	}
}
