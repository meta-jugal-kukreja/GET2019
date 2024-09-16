package question;

import java.util.Date;

/**
 * This class implements the Shape interface.
 * This class overrides the methods of Shape interface to perform desired Operations
 * Assumption : The triangle is right angled triangle
 * @author Jugal
 * Dated 07/24/2019
 */
public class Triangle implements Shape{
	
	double xOrigin, yOrigin, triangleBase, triangleHeight;
	Date timeStamp;
	int shapeId;
	double side1, side2; 
	double x2,y2,x3,y3;
	
	/**
	 * Constructor to initialize Triangle type object
	 * @param xCoordinate is the x coordinate
	 * @param yCoordinate is the y coordinate
	 * @param radius
	 */
	Triangle(double xCoordinate, double yCoordinate, double base, double height, int shapeId)
	{
		xOrigin = xCoordinate;
		yOrigin = yCoordinate;
		triangleBase = base;
		triangleHeight = height;
		timeStamp = new Date();
		this.shapeId = shapeId;
		
		x2 = xOrigin + triangleBase;
		 y2 = yOrigin;
		double intermediateXValue =(triangleBase / 2);
		 y3 = yOrigin + triangleHeight;
		 x3 = xOrigin + intermediateXValue;
		
		side1 = findDistance(xOrigin, yOrigin, x3, y3);
		side2 = findDistance(x3, y3, x2, y2);
	}
	
	/**
	 * Overriding getArea() method to return the area of triangle
	 * @return {double} area of the triangle
	 */
	@Override
	public double getArea() {
		return (0.5 * triangleBase * triangleHeight);
	}

	/**
	 * Overriding getPerimeter() method to return the perimeter of triangle
	 * @return {double} perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		return (triangleBase + side1 + side2);
	}

	/**
	 * Overriding getOrigin() method to return the Origin of triangle
	 * {double[]} coordinates of origin
	 */
	@Override
	public double[] getOrigin() {
		return (new double[] {xOrigin, yOrigin});
	}
	
	/**
	 * Overriding isPointEnclosed() method to return the shapeId of the shape 
	 * @return {int} shapeId of the shape 
	 */
	@Override
	public int getShapeId() {
		return shapeId;
	}

	/**
	 * Overriding isPointEnclosed() method to check whether the point is enclosed in a triangle or not
	 * @return {boolean}
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean answer = false;
		double area1 = findArea(triangleBase, findDistance(xOrigin,yOrigin, point), findDistance(x2, y2, point));
		double area2 = findArea(side1, findDistance(xOrigin,yOrigin, point), findDistance(x3, y3, point));
		double area3 = findArea(side2, findDistance(x3,y3, point), findDistance(x2, y2, point));
		
		if((area1 + area2 + area3) == getArea())
			answer = true;
		return answer;
	}
	
	/**
	 * This method calculates the are of a triangle using herons formula
	 * @param side1 is the first side
	 * @param side2 is the second side
	 * @param side3 is the third side
	 * @return {double} area of the triangle
	 */
	public double findArea(double side1, double side2, double side3)
	{
		double s = (side1 + side2 + side3)/2;
		double area = Math.sqrt(s * (s - 1) * (s - 2) * (s - 3));
		return area;
	}

	/**
	 * This method calculates the distance between two coordinates using distance formula
	 * @param x is the x coordinate
	 * @param y is the y coordinate
	 * @param p is the point of type Point which contains the point
	 * @return {double} distance 
	 */
	public double findDistance(double x, double y, Point p)
	{
		double distance = Math.sqrt((x - p.xPoint)*(x - p.xPoint) + (y - p.yPoint)*(y - p.yPoint));
		return distance;
	}
	
	/**
	 * This method calculates the distance between two coordinates using distance formula
	 * @param x1 is the first x coordinate
	 * @param y1 is the first y coordinate
	 * @param x2 is the second x coordinate
	 * @param y2 is the second y coordinate
	 * @return {double} distance 
	 */
	public double findDistance(double x1, double y1, double x2, double y2)
	{
		double distance = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
		return distance;
	}
}
