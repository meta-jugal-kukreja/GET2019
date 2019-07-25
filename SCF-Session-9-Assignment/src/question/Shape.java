package question;

/**
 * This interface contains method declarations which are to be performed on shapes
 * @author Jugal
 * Dated 07/24/2019
 */
public interface Shape {
	
	 double getArea(); //Method to return the area of the shape
	 double getPerimeter(); //Method to return the perimeter of the shape
	 double[] getOrigin(); //Method to return the origin coordinates of the shape
	 boolean isPointEnclosed(Point point); //Method to check whether a point is enclosed in the shape or not
	 int getShapeId();
	
	//Enum for all type of shapes
	enum ShapeType
	{
		SQUARE, TRIANGLE, RECTANGLE, CIRCLE;
	}

}
