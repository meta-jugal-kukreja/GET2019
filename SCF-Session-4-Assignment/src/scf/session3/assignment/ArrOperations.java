package scf.session3.assignment;

public class ArrOperations {

	/**
	 * This method is used to calculate the length of the the largest mirror
	 * section in an array
	 * 
	 * @param inputArray
	 *            is the array containing all the inputs
	 * @return {int} length of the largest mirror section
	 */
	public int lengthOfLargestMirrorSection(int inputArray[]) {
		if (inputArray.length == 0) //Throwing Assertion Error if array size is 0
			throw new AssertionError("Array size can't be zero");
		int i, j, k;
		int lengthOfMirror = 0;
		int lengthOfIntermediateMirror;
		int arrayLength = inputArray.length;
		for (i = 0; i < arrayLength; i++) {
			lengthOfIntermediateMirror = 0;
			for (j = arrayLength - 1; j >= 0 && (i + lengthOfIntermediateMirror) < arrayLength; j--) {
				if (inputArray[i + lengthOfIntermediateMirror] == inputArray[j]) {
					lengthOfIntermediateMirror++;
				} else {
					lengthOfIntermediateMirror = 0;
				}
			}
			
			lengthOfMirror = Math.max(lengthOfMirror, lengthOfIntermediateMirror);
		}
		return lengthOfMirror;
	}

	/**
	 * This method calculates the number of clumps in the given array
	 * @param inputArray is the array containing inputs
	 * @return {int} number of clumps in the array
	 */
	public int calculateNumberOfClumps(int inputArray[]) {
		if (inputArray.length == 0) //Throwing Assertion Error if array size is 0
			throw new AssertionError("Array size can't be zero");
		int i, j;
		boolean checkingStatus;
		int lengthOfInputArray = inputArray.length;
		int numberOfClumps = 0;
		for (i = 0; i < lengthOfInputArray; i++) {
			checkingStatus = false;
			for (j = 1; (i + j) < lengthOfInputArray; j++) {
				if (inputArray[i] == inputArray[i + j])
					checkingStatus = true;
				else
					break;
			}
			if (checkingStatus) {
				numberOfClumps++;
				i = i + j - 1; //Assigning the value of i to the index of the found clump
			}
		}
		return numberOfClumps;
	}

	/**
	 * This method is used to rearrange the array such that after every X there is Y. Condition is that X's position should be changed
	 * @param inputArray is the array containing inputs
	 * @param X is the value of variable X
	 * @param Y is the value of variable Y
	 * @return {int[]} rearranged array with the given conditions
	 */
	public int[] fixXYproblem(int inputArray[], int X, int Y) {
		if (inputArray.length == 0) //Throwing Assertion Error if array size is 0
			throw new AssertionError("Array size can't be zero"); 
		if (countOccurencesOfX(inputArray, X) != countOccurencesOfY(inputArray,Y)) //Throwing Assertion Error if there are unequal occurrences of X and Y
			throw new AssertionError("There are unequal occurences of X and Y");
		if (checkAdjacencyOfX(inputArray, X)) //Throwing Assertion Error if two X's are adjacent
			throw new AssertionError("Two X values are Adjacent");
		if (inputArray[inputArray.length - 1] == X) //Throwing Assertion Error if X is the last element of the array
			throw new AssertionError("X cannot be at last position of the array");
		int[] outputArray = inputArray;
		for (int i = 0; i < inputArray.length; i++) {
			int indexOfX = searchInArray(outputArray, X, i); //Search index of X
			int indexOfY = searchInArray(outputArray, Y, i); //Search index of Y

			if ((indexOfX >= 0) && (indexOfY >= 0)) {
				/*
				 * This is the code for swapping Y with another number keeping X's position fixed.
				 */
				int temporaryVariable = outputArray[indexOfX + 1];    
				outputArray[indexOfX + 1] = outputArray[indexOfY];
				outputArray[indexOfY] = temporaryVariable;
				i = indexOfX + 2 - 1;
			} else {
				break;
			}
		}
		return outputArray;
	}

	/**
	 *This method splits the array into two parts such that sum of left side portion of splitting point is equal to the sum of right side side portion
	 * @param inputArray is the array containing inputs
	 * @return {int} index of the array before which it can be splitted
	 */
	public int splitArray(int inputArray[]) {
		if (inputArray.length == 0) //Throwing Assertion Error is array size is 0
			throw new AssertionError("Array size can't be zero");
		int lengthOfInputArray = inputArray.length;
		int splitIndex = lengthOfInputArray / 2;
		int terminationCount = 0;
		while (true) {
			terminationCount++;
			if (((sumElementsFromStart(inputArray, lengthOfInputArray) % 2) != 0)
					|| (terminationCount == lengthOfInputArray)) {
				splitIndex = -1;
				break;
			} else {
				int sumFromStart = sumElementsFromStart(inputArray, splitIndex); //Calculating left side sum
				int sumFromEnd = sumElementsFromEnd(inputArray, splitIndex); //Calculationg right side sum
				if (sumFromEnd > sumFromStart) {
					splitIndex++;
				} else if (sumFromStart > sumFromEnd)
					splitIndex--;
				else {
					break;
				}
			}
		}
		return splitIndex;
	}

	/**
	 * This method is used to count the occurrences of the number X in the array
	 * @param inputArray is the array containing inputs
	 * @param X is the number whose occurrences is to be found
	 * @return {int} number of occurrences of X
	 */
	public int countOccurencesOfX(int[] inputArray, int X) {
		int countOfX = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == X)
				countOfX++;
		}
		return countOfX;
	}

	/**
	 * This method is used to count the occurrences of the number Y in the array
	 * @param inputArray is the array containing inputs
	 * @param Y is the number whose occurrences is to be found
	 * @return {int} number of occurrences of Y
	 */
	public int countOccurencesOfY(int[] inputArray, int Y) {
		int countOfY = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == Y)
				countOfY++;
		}
		return countOfY;
	}

	/**
	 * This method is used to check whether two Xs are adjacent
	 * @param inputArray is the array containing inputs
	 * @param X is the number whose occurrences is to be found
	 * @return {boolean}
	 */
	public boolean checkAdjacencyOfX(int[] inputArray, int X) {
		for (int i = 0; i < inputArray.length - 1; i++) {
			if ((inputArray[i] == X) &&(inputArray[i + 1] == X))
				return true;
		}
		return false;
	}

	/**
	 * This method is used to sum elements of an array from index 0 
	 * @param inputArray is the array containing inputs
	 * @param index is the index till where the sum is to be carried out
	 * @return {int} sum of elements
	 */
	public int sumElementsFromStart(int[] inputArray, int index) {
		int sum = 0;
		for (int i = 0; i < index; i++)
			sum = sum + inputArray[i];
		return sum;
	}

	/**
	 * This method is used to sum elements of an array from index @param index 
	 * @param inputArray is the array containing inputs
	 * @param index is the index from where the sum is to be carried out
	 * @return {int} sum of elements
	 */
	public int sumElementsFromEnd(int[] inputArray, int index) {
		int sum = 0;
		for (int i = index; i < inputArray.length; i++)
			sum = sum + inputArray[i];
		return sum;
	}

	/**
	 * This method finds the element in the array
	 * 
	 * @param inputArray is the array of inputs
	 * @param elementToBeFound is the element which to be found
	 * @param index is the position in the array from which the search is to be carried out
	 * @return {int} index of found element if found else -1
	 */
	public int searchInArray(int inputArray[], int elementToBeFound, int index) {
		int i;
		for (i = index; i < inputArray.length; i++) {
			if (inputArray[i] == elementToBeFound)
				break;
		}
		if (i < inputArray.length)
			return i;
		else
			return -1;
	}
}
