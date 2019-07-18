package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This class is used to test the HCF of two numbers
 * @author Jugal
 *
 */
@RunWith(Parameterized.class)
public class NumberOperationsHCFTest {
	
	private int x;
	private int y;
	private int expectedResult;
	private NumberOperations numberObject;

	@Before
	public void initialize() {
		numberObject = new NumberOperations();
	}

	public NumberOperationsHCFTest(int expectedResult, int x, int y) {
		this.expectedResult = expectedResult;
		this.expectedResult = x;
		this.y = y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{90, 180, 270},
				{12 ,300, 396},
				{14, 98, 56}
				});
	}

	@Test
	public void clumpTest() {
		assertEquals(expectedResult, numberObject.computeHCF(x, y));
	}

}
