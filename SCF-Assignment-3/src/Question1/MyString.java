package Question1;

import java.util.Scanner;

public class MyString {

	public static void main(String[] args) {
		MyStringOperations stringObject = new MyStringOperations();
		boolean flag = true;
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
			switch (choice) {
			case 1:
				if (stringObject.stringCompare() == 1)
					System.out.println("Strings are equal");
				else
					System.out.println("Strings are not equal");
				break;
			case 2:
				System.out.println("The reverse of given string is "
						+ stringObject.stringReverse());
				break;
			case 3:
				System.out
						.println("The resultant string after operation on the given string is "
								+ stringObject.stringReverseCharacters());
				break;
			case 4:
				System.out.println("The largest word in the given string is "
						+ stringObject.findLargetestWord());
				break;
			case 5:
				System.out.println("Thank you for using the system.");
				flag = false;
				break;
			default:
			}
		} while (flag);
	}

}
