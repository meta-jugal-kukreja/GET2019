package question;

import java.util.Date;

/**
 * This class implements the Shape interface.
 * This class overrides the methods of Shape interface to perform desired Operations
 * @author Jugal
 * Dated 07/24/2019
 */
public class Rectangle implements Shape {
	
	double xOrigin, yOrigin, lengthOfRectangle, breadthOfRectangle;
	Date timeStamp;
	 int shapeId;
	
	/**
	 * Constructor to initialize Rectangle type object
	 * @param xCoordinate is the x coordinate
	 * @param yCoordinate is the y coordinate
	 * @param radius
	 */
	Rectangle(double xCoordinate, double yCoordinate, double length, double breadth, int shapeId)
	{
		xOrigin = xCoordinate;
		yOrigin = yCoordinate;
		lengthOfRectangle = length;
		breadthOfRectangle = breadth;
		timeStamp = new Date();
		this.shapeId = shapeId;
	}

	/**
	 * Overriding getArea() method to return the area of rectangle
	 * @return {double} area of the rectangle
	 */
	@Override
	public double getArea() {
		return (lengthOfRectangle * breadthOfRectangle);
	}

	/**
	 * Overriding getPerimeter() method to return the perimeter of rectangle
	 * @return {double} perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		return (2 * (lengthOfRectangle + breadthOfRectangle));
	}

	/**
	 * Overriding getOrigin() method to return the Origin of rectangle
	 * {double[]} coordinates of origin
	 */
	@Override
	public double[] getOrigin() {
		return (new double[] {xOrigin, yOrigin});
	}

	/**
	 * Overriding isPointEnclosed() method to check whether the point is enclosed in a rectangle or not
	 * @return {boolean}
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean answer = false;
		if((point.xPoint >= xOrigin) &&(point.yPoint >= yOrigin) &&(point.xPoint <= (xOrigin  + lengthOfRectangle)) &&(point.yPoint <= (yOrigin + breadthOfRectangle)))
			answer = true;
		return answer;
	}
	
	/**
	 * Overriding isPointEnclosed() method to return the shapeId of the shape 
	 * @return {int} shapeId of the shape 
	 */
	@Override
	public int getShapeId() {
		return shapeId;
	}

}
