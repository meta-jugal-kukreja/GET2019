package question1;

import java.util.Scanner;

/**
 * This class contains all the methods to perform operations.
 * @author Admin
 * Dated 07/12/2019
 */
public class MyStringOperations {

	/**
	 * This method compares two strings
	 * @return 1 if equal else 0
	 */
	public int stringCompare(String firstString, String secondString) {
		if (firstString.length() != secondString.length())
			return 0;
		else {
			for (int i = 0; i < firstString.length(); i++) {
				if (firstString.charAt(i) != secondString.charAt(i)) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * This method reverses the string
	 * @return {String}the reversed string
	 */
	public String stringReverse(String inputString) {

		char[] stringArray = inputString.toCharArray();
		for (int i = 0, j = (inputString.length() - 1); i < stringArray.length/2; i++, j--) {
			char swappingChar = stringArray[i];
			stringArray[i] = stringArray[j];
			stringArray[j] = swappingChar;
		}

		return new String(stringArray);
	}
	
	/**
	 * This method converts upper case characters of a string to lower case characters and vice versa
	 * @return {String}The resultant string
	 */
	public String stringReverseCharacters(String inputString) {
		StringBuilder resultantString = new StringBuilder(inputString);
		for (int i = 0; i < inputString.length(); i++) {
			char tempChar = inputString.charAt(i);
			if (tempChar != ' ') {
				if (Character.isUpperCase(tempChar)) {
					int asciiValue = (int) tempChar;
					asciiValue = asciiValue + 32;
					tempChar = (char) asciiValue;
					resultantString.setCharAt(i, tempChar);
				} else {
					int asciiValue = (int) tempChar;
					asciiValue = asciiValue - 32;
					tempChar = (char) asciiValue;
					resultantString.setCharAt(i, tempChar);
				}
			} else
				resultantString.append(' ');
		}
		return resultantString.toString();
	}

	/**
	 * This method finds the largest word in the string
	 * @return {String} if multiple words have largest length then last word 
	 * 					else the largest word
	 */
	public String findLargestWord(String inputString) {
		inputString = inputString + ' ';

		String largestWord = "";
		int largestWordCount = 0;
		String intermediateWord = "";
		int intermediateWordCount = 0;

		for (int i = 0; i < inputString.length(); i++) {

			if (inputString.charAt(i) != ' ') {
				intermediateWord = intermediateWord + inputString.charAt(i);
				intermediateWordCount++;
			} else {
				if (intermediateWordCount >= largestWordCount) {
					largestWord = intermediateWord;
					largestWordCount = intermediateWordCount;
				}
				intermediateWord = "";
				intermediateWordCount = 0;
			}
		}
		return largestWord;
	}
}
