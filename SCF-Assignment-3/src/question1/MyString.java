package question1;

import java.util.Scanner;

/**
 * This is the driver class to perform all the operations. 
 * Assumptions are that the string is not null and case sensitive
 * @author Admin
 * Dated 07/12/2019
 */
public class MyString {

	public static void main(String[] args) {
		MyStringOperations stringObject = new MyStringOperations();
		boolean flag = true;
		String inputString;
		System.out.println("Following String operations are available : ");
		System.out.println("1. Compare two strings.");
		System.out.println("2. Reverse the content of a string");
		System.out
		.println("3. Replace lowercase characters with uppercase and vice-versa. ");
		System.out.println("4. Get largest word in the string.");
		System.out.println("5. Exit");
		do {
			System.out.print("\nEnter your choice in numbers(1/2/3/4/5) : ");
			Scanner inputScanner = new Scanner(System.in);
			int choice = inputScanner.nextInt();
			inputString = inputScanner.nextLine();
			switch (choice) {
			case 1:
				String firstString, secondString;

				System.out.print("\nEnter first string : ");
				firstString = inputScanner.nextLine();
				System.out.print("Enter second string : ");
				secondString = inputScanner.nextLine();
				if (stringObject.stringCompare(firstString, secondString) == 1)
					System.out.println("Strings are equal");
				else
					System.out.println("Strings are not equal");
				break;
			case 2:
				System.out.print("\nEnter the string : ");
				inputString = inputScanner.nextLine();
				System.out.println("The reverse of given string is : "
						+ stringObject.stringReverse(inputString));
				break;
			case 3:
				System.out.print("\nEnter the string : ");
				inputString = inputScanner.nextLine();
				System.out
				.println("The resultant string after operation on the given string is : "
						+ stringObject.stringReverseCharacters(inputString));
				break;
			case 4:
				System.out.print("\nEnter the string : ");
				inputString = inputScanner.nextLine();
				System.out.println("The largest word in the given string is : "
						+ stringObject.findLargestWord(inputString));
				break;
			case 5:
				System.out.println("Thank you for using the system.");
				flag = false;
				break;
			default: System.out.println("Enter the correct choice");
			}
		} while (flag);
	}

}
