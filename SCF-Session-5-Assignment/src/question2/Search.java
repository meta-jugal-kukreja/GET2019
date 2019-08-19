package question2;

import org.junit.Test;

/**
 * This class contains methods of linear search and binary search
 * @author Jugal Dated 07/18/2019
 */
public class Search {
	/**
	 * This method searches an element in sequentially in an array
	 * @param inputArray contains all the input elements
	 * @param elementToBeSearch is the element to be searched
	 * @return {int} -1 if element is not found else index of the element
	 */
	public int linearSearch(int[] inputArray, int elementToBeSearch, int index) {
		if (index == inputArray.length)
			return -1;
		if ((inputArray[index] == elementToBeSearch) && (index < inputArray.length))
			return index;
		return linearSearch(inputArray, elementToBeSearch, index + 1);
	}

	/**
	 * This method searches an element in an sorted array through binary search
	 * @param inputArray contains all the input elements 
	 * @param elementToBeSearch is the element to be searched
	 * @return {int} -1 if element is not found else index of the element
	 */
	public int binarySearch(int[] inputArray, int elementToBeSearch, int start, int end) {
		if (end >= start) {
			int mid = (start + end) / 2;
			if (inputArray[mid] == elementToBeSearch)
				return mid;
			else if (inputArray[mid] > elementToBeSearch)
				return binarySearch(inputArray, elementToBeSearch, start, mid - 1);
			else
				return binarySearch(inputArray, elementToBeSearch, mid + 1, end);
		}
		return -1;
	}

}
