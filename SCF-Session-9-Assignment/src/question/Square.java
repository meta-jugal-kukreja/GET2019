package question;

import java.util.Date;

/**
 * This class implements the Shape interface.
 * This class overrides the methods of Shape interface to perform desired Operations
 * @author Jugal
 * Dated 07/24/2019
 */
public class Square implements Shape {

	double xOrigin, yOrigin, sideOfSquare;
	Date timeStamp;
	 int shapeId;
	
	/**
	 * Constructor to initialize Square type object
	 * @param xCoordinate is the x coordinate
	 * @param yCoordinate is the y coordinate
	 * @param radius
	 */
	Square(double xCoordinate, double yCoordinate, double side, int shapeId)
	{
		xOrigin = xCoordinate;
		yOrigin = yCoordinate;
		sideOfSquare = side;
		timeStamp = new Date();
		this.shapeId = shapeId;
	}
	
	/**
	 * Overriding getArea() method to return the area of square
	 * @return {double} area of the square
	 */
	@Override
	public double getArea() {
		return (sideOfSquare * sideOfSquare);
	}

	/**
	 * Overriding getPerimeter() method to return the perimeter of square
	 * @return {double} perimeter of square
	 */
	@Override
	public double getPerimeter() {
		return (4 * sideOfSquare);
	}

	/**
	 * Overriding getOrigin() method to return the Origin of square
	 * {double[]} coordinates of origin
	 */
	@Override
	public double[] getOrigin() {
		return (new double[] {xOrigin, yOrigin});
	}

	/**
	 * Overriding isPointEnclosed() method to check whether the point is enclosed in a square or not
	 * @return {boolean}
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean answer = false;
		if((point.xPoint >= xOrigin) &&(point.yPoint >= yOrigin) &&(point.xPoint <= (xOrigin  + sideOfSquare)) &&(point.yPoint <= (yOrigin + sideOfSquare)))
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
