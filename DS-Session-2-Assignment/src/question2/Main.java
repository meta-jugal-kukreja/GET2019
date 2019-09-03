package question2;

import java.util.Scanner;

/**
 * This class handles the UI part of the QueueImplementation class
 * @author Jugal
 * Dated 07/31/2019
 */
public class Main {

	public static void main(String[] args) throws Exception {

		int choice, item;
		Scanner inputScanner = new Scanner(System.in);
		Queue queue = new QueueImplementation();

		do {
			System.out.println("\n1.Insert an element");
			System.out.println("2.Delete an element");
			System.out.println("3.Display an element");
			System.out.println("4.Quit");

			System.out.print("Enter your choice : ");
			choice = Integer.parseInt(inputScanner.next());

			switch (choice) {
			case 1:
				System.out.print("\nInput the element for insertion in queue : ");
				item = Integer.parseInt(inputScanner.next());
				queue.enqueue(item);
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				System.out.println("\nThe queue is : ");
				queue.displayQueue();
				break;
			case 4:
				break;
			default:
				System.out.println("Wrong choice\n");
			}
		} while (choice != 4);

	}

}
