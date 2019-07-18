package question3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class is the driver class which is calling methods for operations
 * @author Admin
 *  Dated 07/15/2019 
 */
public class Area {
	
	public static void main(String[] args) {
		AreaOperations areaObject = new AreaOperations();
		
		boolean flag = true;
		System.out.println("Following operations are available : ");
		System.out.println("1. Calculate area of Triangle.");
		System.out.println("2. Calculate area of Rectangle.");
		System.out
		.println("3. Calculate area of Square. ");
		System.out.println("4. Calculate area of Circle.");
		System.out.println("5. Exit");
		do {
			System.out.print("\nEnter your choice in numbers(1/2/3/4/5) : ");
			Scanner inputScanner = new Scanner(System.in);
			int choice = inputScanner.nextInt();
			switch (choice) {
			case 1:
				double heightOfTriangle, baseOfTriangle;
				System.out.print("\nEnter height of triangle : ");
				heightOfTriangle = inputScanner.nextInt();
				System.out.print("Enter base of traingle : ");
				baseOfTriangle = inputScanner.nextInt();
				System.out.println("The area of traingle is : " + areaObject.calculateAreaOfTriangle(baseOfTriangle, heightOfTriangle));
				break;
			case 2:
				double lengthOfRectangle, breadthOfRectangle;
				System.out.print("\nEnter length of rectangle : ");
				lengthOfRectangle = inputScanner.nextInt();
				System.out.print("Enter breadth of retangle : ");
				breadthOfRectangle = inputScanner.nextInt();
				System.out.println("The area of traingle is : " + areaObject.calculateAreaOfRectangle(lengthOfRectangle, breadthOfRectangle));
				break;
			case 3:
				double sideOfSquare;
				System.out.print("\nEnter the side of square : ");
				sideOfSquare = inputScanner.nextInt();
				System.out.println("The area of square is : " + areaObject.calculateAreaOfSquare(sideOfSquare));
				break;
			case 4:
				double radiusOfCircle;
				System.out.print("\nEnter the radius of circle : ");
				radiusOfCircle = inputScanner.nextInt();
				System.out.println("The area of circle is : " + areaObject.calculateAreaOfCircle(radiusOfCircle));
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
