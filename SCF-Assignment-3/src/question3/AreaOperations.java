 package question3;

 /**
  * This class contains all the methods which performs the operations
  * @author Admin
  * Dated 07/15/2019
  */
public class AreaOperations {

	/**
	 * This method calculates the area of triangle
	 * @param {double}base is the base of the triangle
	 * @param {double}height is the height of the triangle
	 * @return {double}area of the triangle.
	 */
	public double calculateAreaOfTriangle(double base, double height)
	{
		double area = 0.0;
		try
		{
		area = 0.5 * base * height;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		return area;
	}
	
	/**
	 * This method calculates the area of rectangle
	 * @param {double}length is the length of the triangle
	 * @param {double}breadth is the width of the triangle
	 * @return {double}area of the rectangle.
	 */
	public double calculateAreaOfRectangle(double length, double breadth)
	{
		double area = 0.0;
		try
		{
		area = length * breadth;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		return area;

	}
	
	/**
	 * This method calculates the area of square
	 * @param {double}side is the side of the square
	 * @return {double}area of the square.
	 */
	public double calculateAreaOfSquare(double side)
	{
		double area = 0.0;
		try
		{
		area = side * side;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		return area;

	}
	
	/**
	 * This method calculates the area of circle
	 * @param {double}radius is the radius of the circle
	 * @return {double}area of the circle.
	 */
	public double calculateAreaOfCircle(double radius)
	{
		double area = 0.0;
		try
		{
		area = Math.PI * radius * radius;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		return area;

	}
}
