package question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class consists of a list of shapes on the screen and a list of shapes on the screen enclosing the given point.
 * The class has methods to add a shape to the screen, to delete a shape from the screen, to delete all shapes from the screen 
 * and to check which shapes are enclosing the given point.
 * @author Jugal
 * Dated 07/24/2019
 */
public class Screen {
	
	public static final double XMAX=1000, YMAX=1000, XMIN=0, YMIN=0;
	List<Shape> shapeList = new ArrayList<>();
	
	static Screen screenObject = new Screen();
	
	/**
	 * Method to allow user to get the object of class Screen instead of re-instantiating.
	 *
	 *@return private object of Singleton class Screen.
	 */
	public static Screen getScreenObject()
	{
		return screenObject;
	}
	
	/**
	 * Method to add a shape to the screen.
	 * This method calls the createShape method of ShapeFactory class
	 	to create the respective shape.
	 * 
	 * @param inputShape of the shape to be created as string
	 * @param param is the parameters of the shape created as a double array.
	 */
	void addShape(String inputShape, double[] param)
	{			
		Shape newShape = ShapeFactory.buildShapeObject(inputShape, param);
		shapeList.add(newShape);
	}
	
	/**
	 * This method removes all shapes from the screen.
	 */
	void deleteAll()
	{
		shapeList.clear();
		
	}
	
	/**
	 * Method to delete a shape at a time from the screen.
	 * 
	 * @param shapeName of the shape type as string.
	 * @param shapeId of that shape as int.
	 */
	void deleteShape(String shapeName, int shapeId)
	{
		//Iterator to iterate through the list of shapes on the screen.
		Iterator<Shape> shapeItr = shapeList.iterator();
		while(shapeItr.hasNext())
		{
			Shape s = shapeItr.next();
			
			if(s.getShapeId() == shapeId && s.getClass().getSimpleName().equalsIgnoreCase(shapeName))
			{
				shapeItr.remove();
			}
		}
	}
	
	/**
	 * To add the shapes enclosing the given point
	 * 
	 * @param reference of the object of point p of type Point.
	 * @return {List<Shape>} list of enclosing points
	 */
	List<Shape> enclosingShapes(Point p)
	{
		List<Shape> shapesEnclosingPoint = new ArrayList<Shape>();	//List to store the shapes enclosing the given point.
		
		Iterator<Shape> shapeItr = shapeList.iterator();
		
		while(shapeItr.hasNext())
		{
			Shape s = shapeItr.next();
			
			if(s.isPointEnclosed(p))
			{
				shapesEnclosingPoint.add(s);
			}
		}
		
		return shapesEnclosingPoint;
	}

}
