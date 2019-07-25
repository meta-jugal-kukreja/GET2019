package question;

/**
 * Class ShapeFactory is a class which determines which type of shape is to be created.
 * The class provides shape id to each shape created.
 * It also validates if a shape can be created for the given screen.
 * 
 * @author Jugal
 * Dated 07/24/2019
 */
public class ShapeFactory {
	
	static int shapeId = 0;
	
	/**
	 * Method to create a shape according to the given name and dimensions.
	 * 
	 * @param an array of values of origin coordinate, length, width, side, radius, etc. of the respective shape.
	 * @return object of the respective shape.
	 */
	static Shape buildShapeObject(String inputShape, double[] param)
	{
		Shape s = null;
		String inputShape2 = inputShape.toUpperCase();				//Converting the shape type to uppercase for comparison with enum.
		Shape.ShapeType type = Shape.ShapeType.valueOf(inputShape2);				//Converting the input shape type to enum.
		
		//Checking whether the input shape type is which one. Assertion Error if invalid type is as input.
		switch(type)
		{
		case RECTANGLE:
			assert !(validateShape( param[0], param[1], param[2], param[3])) : "Rectangle cannot be created";				//Checking if the shape can be created in the screen with given dimensions.
			
			 s = new Rectangle( param[0], param[1], param[2], param[3], ++shapeId);
			 break;
			 
		case TRIANGLE:
			assert !(validateShape( param[0], param[1], param[2], param[3])) : "Triangle cannot be created";
			
			 s = new Triangle(param[0], param[1], param[2], param[3], ++shapeId); 
			 break; 
			 
		case SQUARE:
			assert !(validateSquare( param[0], param[1], param[2])) : "Square cannot be created";
			
			s = new Square(param[0], param[1], param[2], ++shapeId);
			break;
			
		case CIRCLE:
			//assert !(validateCircle(param)) : "Circle cannot be created";
			if(!(validateCircle(param)))
				throw new AssertionError();
			
			s = new Circle(param[0], param[1], param[2], ++shapeId);
			break;
			
		default:
			throw new AssertionError();
		}
		
		return s;
	}

	/**
	 * Method to check if the square can be built in the screen with given dimensions.
	 * 
	 * @param origin coordinates and sides of the rectangle, square or triangle as an array of double.
	 * @return true of false as per the validation.
	 */
	static boolean validateSquare(double x, double y, double s)
	{
		if(x > Screen.XMIN && y > Screen.YMIN && x+s <= Screen.XMAX && y+s <= Screen.YMAX)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if the rectangle or triangle can be built in the screen with given dimensions.
	 * 
	 * @param origin coordinates and sides of the rectangle, square or triangle as an array of double.
	 * @return true of false as per the validation.
	 */
	static boolean validateShape(double x, double y, double s1, double s2)
	{
		if(x > Screen.XMIN && y > Screen.YMIN && x+s1 <= Screen.XMAX && y+s2 <= Screen.YMAX)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if the rectangle can be built in the screen with given dimensions
	 * by comparing the center point with its distance from x and y axis.
	 * 
	 * @param origin coordinates & radius of the circle as an array of double.
	 * @return true of false as per the validation.
	 */
	static boolean validateCircle(double[] param)
	{
		double toOriginLength = Math.sqrt(param[0]*param[0] + param[1]*param[1]);
		double toCentreLength = toOriginLength + param[2];
		
		double[] centrePoint = new double[2];
		
		//finding the centre of the circle.
		centrePoint[0] = (toCentreLength * param[0])/toOriginLength;
		centrePoint[1] = (toCentreLength * param[1])/toOriginLength;
		
		if(centrePoint[0]+param[2] <= Screen.XMAX && centrePoint[0]-param[2] >= Screen.XMIN && centrePoint[1]+param[2] <= Screen.YMAX &&centrePoint[1]-param[2] >= Screen.YMIN)
			return true;
		else
			return false;
	}
}
