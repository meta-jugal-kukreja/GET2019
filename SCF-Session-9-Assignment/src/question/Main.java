package question;

import java.util.Scanner;

public class Main {

	static Screen screen = new Screen();

	public static void main(String[] args) {
		String choice;
		boolean flag = true;
		Scanner inputScanner = new Scanner(System.in);

		do {
			System.out.println("\nMenu : \n");
			System.out.println("1. Add a New Shape to the Screen.");
			System.out.println("2. Delete a shape from the screen.");
			System.out.println("3. Delete all shapes from the screen.");
			System.out.println("4. Dsiplay Shapes enclosing a given point.");
			System.out.println("5. Display the Screen.");
			System.out.println("6. Exit");

			System.out.print("\nEnter your choice please : ");
			choice = inputScanner.nextLine();

			switch (choice) {
			case "1":
				addShapeToScreen();
				System.out.println("Shape added");
				break;

			case "2":
				deleteAShapeFromScreen();
				break;

			case "3":
				deleteAllShapesFromScreen();
				break;

			case "4":
				shapesEnclosingAPoint();
				break;

			case "5":
				displayScreen();
				break;

			case "6":
				flag = false;
				break;

			default:
				System.out.println("Wrong selection!");
			}

		} while (flag);

	}

	private static void displayScreen() {

		Scanner inputScanner = new Scanner(System.in);
		double xOrigin, yOrigin;
		System.out.println("Enter the type of shape you want to add : ");
		String shapeType = inputScanner.nextLine();
		switch (shapeType.toLowerCase()) {
		
		case "square":
			System.out.println("Enter the x coordinate of the origin of the square : ");
			xOrigin = inputScanner.nextDouble();
			System.out.println("Enter the y coordinate of the origin of the square : ");
			yOrigin = inputScanner.nextDouble();
			System.out.println("Enter the side of the square : ");
			double squareSide = inputScanner.nextDouble();

			double[] squareParams = { xOrigin, yOrigin, squareSide };
			screen.addShape(shapeType, squareParams);
			break;

		case "triangle":
			System.out.println("Enter the x coordinate of the origin of the triangle : ");
			xOrigin = inputScanner.nextDouble();
			System.out.println("Enter the y coordinate of the origin of the triangle : ");
			yOrigin = inputScanner.nextDouble();
			System.out.println("Enter the base of the triangle : ");
			double triangleBase = inputScanner.nextDouble();
			System.out.println("Enter the height of the triangle : ");
			double triangleHeight = inputScanner.nextDouble();

			double[] triangleParams1 = { xOrigin, yOrigin, triangleBase, triangleHeight };
			screen.addShape(shapeType, triangleParams1);
			break;

		case "rectangle":
			System.out.println("Enter the x coordinate of the origin of the square : ");
			xOrigin = inputScanner.nextDouble();
			System.out.println("Enter the y coordinate of the origin of the square : ");
			yOrigin = inputScanner.nextDouble();
			System.out.println("Enter the length of the rectangle : ");
			double rectangleLength = inputScanner.nextDouble();
			System.out.println("Enter the breadth of the rectangle : ");
			double rectangleBreadth = inputScanner.nextDouble();

			double[] rectangleParams = { xOrigin, yOrigin, rectangleLength, rectangleBreadth };
			screen.addShape(shapeType, rectangleParams);
			break;

		case "circle":
			System.out.println("Enter the x coordinate of the origin of the square : ");
			xOrigin = inputScanner.nextDouble();
			System.out.println("Enter the y coordinate of the origin of the square : ");
			yOrigin = inputScanner.nextDouble();
			System.out.println("Enter the side of the square : ");
			double circleRadius = inputScanner.nextDouble();

			double[] circleParams = { xOrigin, yOrigin, circleRadius};
			screen.addShape(shapeType, circleParams);

		default:
			System.out.println("Enter a valid shape type.");

		}
	}

	private static void shapesEnclosingAPoint() {
		// TODO Auto-generated method stub

	}

	private static void deleteAllShapesFromScreen() {
		// TODO Auto-generated method stub

	}

	private static void deleteAShapeFromScreen() {
		
		

	}

	private static void addShapeToScreen() {
		// TODO Auto-generated method stub

	}

}
