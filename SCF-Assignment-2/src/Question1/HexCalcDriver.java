package Question1;

import java.util.Scanner;

/**
 * This is the driver class for HexCalc class
 */
public class HexCalcDriver {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		HexCalc hexCalcObject = new HexCalc();

		System.out.println("What do you want to do? ");
		System.out.println("1. Convert Hexadecimal number to Decimal number.");
		System.out.println("2. Convert Decimal number to Hexadecimal number.");
		System.out
				.println("3. Perform Arithematic Opertaions on two Hexadecimal numbers");
		System.out.println("4. Compare two Hexadecimal Numbers.");
		System.out.println("5. Exit");

		boolean flag = true;
		do {
			System.out.print("\nEnter your Choice : ");
			int choice = inputScanner.nextInt();
			int decimalNumber;
			switch (choice) {
			case 1:
				System.out.print("\nEnter the Hexaecimal number : ");
				String hexadecimalNumber = inputScanner.next();
				decimalNumber = hexCalcObject
						.convertHexadecimalNumberToDecimalNumber(hexadecimalNumber);
				if (decimalNumber < 0) {
					System.out.println("This is an invalid hexadecimal number");
				} else {
					System.out.println("Decimal Representation of "
							+ hexadecimalNumber + " is : " + decimalNumber);
				}
				break;
			case 2:
				System.out.print("\nEnter the Decimal number : ");
				decimalNumber = inputScanner.nextInt();
				System.out
						.println("Hexadecimal Representation of "
								+ decimalNumber
								+ " is : "
								+ hexCalcObject
										.convertDecimalNumberToHexadecimalNumber(decimalNumber));
				break;
			case 3:
				hexCalcObject
						.performArithematicOpertaionsOnTwoHexadecimalNumbers();
				break;
			case 4:
				hexCalcObject.compareTwoHexadecimalNumbers();
				break;
			case 5:
				System.out.println("Thank You for Using the system.");
				flag = false;
				break;
			default:
				System.out.println("Enter correct choice.");
			}
		} while (flag);

	}

}
