package question1;

import java.util.Scanner;

public class HexCalc {
	private final String HEXADECIMAL_DIGITS = "0123456789ABCDEF"; // This string
																	// contains
																	// all the
																	// hexadecimal
																	// characters

	/**
	 * Converts Hexadecimal number to decimal number.
	 * 
	 * @param hexadecimalNumber
	 *            is the hexadecimal number string.
	 * @return {int} decimal number
	 */
	public int convertHexadecimalNumberToDecimalNumber(String hexadecimalNumber) {

		hexadecimalNumber = hexadecimalNumber.toUpperCase();
		int decimalNumber = 0;
		for (int i = 0; i < hexadecimalNumber.length(); i++) {
			char character = hexadecimalNumber.charAt(i);
			int number = HEXADECIMAL_DIGITS.indexOf(character);
			decimalNumber = 16 * decimalNumber + number;
		}
		return decimalNumber;
	}

	/**
	 * This method checks whether the hexadecimal string is a valid is a valid
	 * hexadecimal number
	 * 
	 * @param hexadecimalNumber
	 *            is the hexadecimal string to be validated
	 * @return {boolean}true if the hexadecimal string is valid hexadecimal
	 *         number else false
	 */
	public boolean hexadecimalNumberValidation(String hexadecimalNumber) {
		hexadecimalNumber = hexadecimalNumber.toUpperCase();
		for (int i = 0; i < hexadecimalNumber.length(); i++) {
			char character = hexadecimalNumber.charAt(i);
			if (HEXADECIMAL_DIGITS.indexOf(character) < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Converts Decimal number to Hexadecimal number
	 * 
	 * @param decimalNumber
	 *            is the integer decimal number
	 * @return {String} hexadecimal number string
	 */
	public String convertDecimalNumberToHexadecimalNumber(int decimalNumber) {
		int intermediateNumber;
		String hexadecimalNumber = "";
		String HEXADECIMAL_DIGITS = "0123456789ABCDEF";

		if (decimalNumber != 0) {
			while (decimalNumber > 0) {

				intermediateNumber = decimalNumber % 16;
				hexadecimalNumber = HEXADECIMAL_DIGITS
						.charAt(intermediateNumber) + hexadecimalNumber;
				decimalNumber = decimalNumber / 16;
			}
		} else
			hexadecimalNumber = "0";
		return hexadecimalNumber;
	}

	/**
	 * Driver method to perform arithematic operations on two hexadecimal
	 * numbers
	 */
	public void performArithematicOpertaionsOnTwoHexadecimalNumbers() {
		Scanner inputScanner = new Scanner(System.in);
		String number1, number2;
		int choice = 0;

		System.out.println("What do you want to do? ");
		System.out.println("1. Add two Hexadecimal numbers.");
		System.out.println("2. Subtract two Hexadecimal numbers.");
		System.out.println("3. Multiply two Hexadecimal numbers.");
		System.out.println("4. Divide two Hexadecimal numbers.");
		System.out.println("5. Return to previous menu.");

		System.out.print("Enter your Choice : ");
		try {
			choice = inputScanner.nextInt();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

		System.out.print("\nEnter Hexadecimal Number 1 : ");
		number1 = inputScanner.next();
		number1.toUpperCase();
		System.out.print("Enter Hexadecimal Number 2 : ");
		number2 = inputScanner.next();
		number2.toUpperCase();

		switch (choice) {
		case 1:
			System.out
					.println("\nAddition of the given two hexadecimal numbers is "
							+ addTwoHexadecimalNumbers(number1, number2));
			break;
		case 2:
			if (isFirstGreater(number1, number2))
				System.out
						.println("\nSubtraction of the given two hexadecimal numbers is "
								+ subtractTwoHexadecimalNumbers(number1,
										number2));
			else
				System.out
						.println("\nSubtraction of the given two hexadecimal numbers is -"
								+ subtractTwoHexadecimalNumbers(number1,
										number2));
			break;
		case 3:
			System.out
					.println("\nMultiplication of the given two hexadecimal numbers is "
							+ multiplyTwoHexadecimalNumbers(number1, number2));
			break;
		case 4:
			System.out
					.println("\nThe division of two hexadecimal number results as : ");
			System.out.println(divideTwoHexadecimalNumbers(number1, number2));
			break;
		case 5:
			return;
		default:
			System.out
					.println("Addition of the given two hexadecimal numbers is ");
		}
	}

	/**
	 * Driver method to perform comparision operations on two hexadecimal
	 * numbers
	 */
	public void compareTwoHexadecimalNumbers() {
		Scanner inputScanner = new Scanner(System.in);
		String number1, number2;

		System.out.print("\nEnter Hexadecimal Number 1 : ");
		number1 = inputScanner.next();
		System.out.print("Enter Hexadecimal Number 2 : ");
		number2 = inputScanner.next();

		if (checkEqualityOfTwoHexadecimalNumbers(number1, number2))
			System.out.println("Two numbers are equal");
		else if (isFirstGreater(number1, number2))
			System.out.println("First Number is greater");
		else if (isFirstSmaller(number1, number2))
			System.out.println("Second number is greater");
	}

	/**
	 * Adds two hexadecimal numbers
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {String}addition of two hexadecimal numbers
	 */
	public String addTwoHexadecimalNumbers(String number1, String number2) {
		int decimalNumber1 = convertHexadecimalNumberToDecimalNumber(number1);
		int decimalNumber2 = convertHexadecimalNumberToDecimalNumber(number2);
		int resultantDecimalNumber = decimalNumber1 + decimalNumber2;
		return convertDecimalNumberToHexadecimalNumber(resultantDecimalNumber);
	}

	/**
	 * Subtracts two hexadecimal numbers
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {String}subtraction of two hexadecimal numbers
	 */
	public String subtractTwoHexadecimalNumbers(String number1, String number2) {
		int decimalNumber1 = convertHexadecimalNumberToDecimalNumber(number1);
		int decimalNumber2 = convertHexadecimalNumberToDecimalNumber(number2);
		int resultantDecimalNumber = decimalNumber1 - decimalNumber2;
		return convertDecimalNumberToHexadecimalNumber(Math
				.abs(resultantDecimalNumber));
	}

	/**
	 * Multiplies two hexadecimal numbers
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {String}multiplication of two hexadecimal numbers
	 */
	public String multiplyTwoHexadecimalNumbers(String number1, String number2) {
		int decimalNumber1 = convertHexadecimalNumberToDecimalNumber(number1);
		int decimalNumber2 = convertHexadecimalNumberToDecimalNumber(number2);
		int resultantDecimalNumber = decimalNumber1 * decimalNumber2;
		return convertDecimalNumberToHexadecimalNumber(resultantDecimalNumber);
	}

	/**
	 * Divides two hexadecimal numbers
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {String}Quotient and Remainder of two hexadecimal numbers
	 */
	public String divideTwoHexadecimalNumbers(String number1, String number2) {
		int decimalNumber1 = convertHexadecimalNumberToDecimalNumber(number1);
		int decimalNumber2 = convertHexadecimalNumberToDecimalNumber(number2);
		int quotient = decimalNumber1 / decimalNumber2;
		int remainder = decimalNumber1 % decimalNumber2;
		String resultantNumber = "Quotient = "
				+ convertDecimalNumberToHexadecimalNumber(quotient)
				+ "\nRemainder = "
				+ convertDecimalNumberToHexadecimalNumber(remainder);
		return resultantNumber;
	}

	/**
	 * Checks if two hexadecimal numbers are equal
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return true if equal else false
	 */
	public boolean checkEqualityOfTwoHexadecimalNumbers(String number1,
			String number2) {
		return number1.equals(number2);
	}

	/**
	 * Checks if first hexadecimal number is greater than another
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {boolean}true if equal else false
	 */
	public boolean isFirstGreater(String number1, String number2) {
		boolean answer = false;
		if (number1.length() > number2.length())
			answer = true;
		else if (number1.length() < number2.length())
			answer = false;
		else {
			for (int i = 0; i < number1.length(); i++) {
				if (number1.charAt(i) != number2.charAt(i)) {
					if (number1.charAt(i) > number2.charAt(i)) {
						answer = true;
						break;
					} else {
						answer = false;
						break;
					}
				}
			}
		}
		return answer;
	}

	/**
	 * Checks if first hexadecimal number is smaller than another
	 * 
	 * @param number1
	 *            is the first hexadecimal number string
	 * @param number2
	 *            is the second hexadecimal number string
	 * @return {boolean}true if equal else false
	 */
	public boolean isFirstSmaller(String number1, String number2) {
		boolean answer = false;
		if (number1.length() < number2.length())
			answer = true;
		else if (number1.length() > number2.length())
			answer = false;
		else {
			for (int i = 0; i < number1.length(); i++) {
				if (number1.charAt(i) != number2.charAt(i)) {
					if (number1.charAt(i) < number2.charAt(i)) {
						answer = true;
						break;
					} else {
						answer = false;
						break;
					}
				}
			}
		}
		return answer;
	}
}
