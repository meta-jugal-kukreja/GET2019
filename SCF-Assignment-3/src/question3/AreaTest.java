package question3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AreaTest {
	
	private AreaOperations areaObject;
	
	@Before
	public void initialize() {
		areaObject = new AreaOperations();
	}

	// This method tests calculateAreaOfTriangle methods
		@Test
		public void calculateAreaOfTriangleTest() {
			assertEquals(10.0,(double) areaObject.calculateAreaOfTriangle(2.0, 10.0),(double) 0.0);
		}
		
		// This method tests calculateAreaOfRectangle methods
				@Test
				public void calculateAreaOfRectangleTest() {
					assertEquals(20.0,(double) areaObject.calculateAreaOfRectangle(2.0, 10.0),(double) 0.0);
				}
				
				// This method tests calculateAreaOfSquare methods
				@Test
				public void calculateAreaOfSquareTest() {
					assertEquals(20.0,(double) areaObject.calculateAreaOfRectangle(2.0, 10.0),(double) 0.0);
				}
				
				// This method tests calculateAreaOfCircle methods
				@Test
				public void calculateAreaOfCircleTest() {
					assertEquals(314.1592653589793,(double) areaObject.calculateAreaOfCircle(10.0),(double) 0.0);
				}
}
