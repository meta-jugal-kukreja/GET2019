package question;

import java.util.Date;

/**
 * This class implements the Shape interface.
 * This class overrides the methods of Shape interface to perform desired Operations
 * @author Jugal
 * Dated 07/24/2019
 */
public class Circle implements Shape {
	
	double xOrigin, yOrigin, radiusOfCircle;
	Date timeStamp;
	int shapeId;
	
	/**
	 * Constructor to initialize Circle type object
	 * @param xCoordinate is the x coordinate
	 * @param yCoordinate is the y coordinate
	 * @param radius
	 */
	Circle(double xCoordinate, double yCoordinate, double radius, int shapeId)
	{
		xOrigin = xCoordinate;
		yOrigin = yCoordinate;
		radiusOfCircle = radius;
		timeStamp = new Date();
		this.shapeId = shapeId;
	}

	/**
	 * Overriding getArea() method to return the area of circle
	 * @return {double} area of the circle
	 */
	@Override
	public double getArea() {
		return (Math.PI * radiusOfCircle * radiusOfCircle);
	}

	/**
	 * Overriding getPerimeter() method to return the perimeter of circle
	 * @return {double} perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		return (2 * Math.PI * radiusOfCircle);
	}

	/**
	 * Overriding getOrigin() method to return the Origin of circle
	 * {double[]} coordinates of origin
	 */
	@Override
	public double[] getOrigin() {
		return (new double[] {xOrigin, yOrigin});
	}

	/**
	 * Overriding isPointEnclosed() method to check whether the point is enclosed in a circle or not
	 * @return {boolean}
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		double[] centre = getCircleCentre();
		double distance = Math.sqrt((centre[0] - point.xPoint)*(centre[0] - point.xPoint) + (centre[1] - point.yPoint)*(centre[1] - point.yPoint));
		
		if(distance <= radiusOfCircle)
			return true;
		
		return false;
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
	 * This method finds the centre coordinates of a circle
	 * @return {double[]} centre coordinates
	 */
	double[] getCircleCentre()
	{
		double toOriginLength = Math.sqrt(xOrigin*xOrigin + yOrigin*yOrigin);
		double toCentreLength = toOriginLength + radiusOfCircle;
		
		double[] centrePoint = new double[2];
		
		centrePoint[0] = (toCentreLength * xOrigin)/toOriginLength;
		centrePoint[1] = (toCentreLength * yOrigin)/toOriginLength;
		
		return centrePoint;
	}

}
