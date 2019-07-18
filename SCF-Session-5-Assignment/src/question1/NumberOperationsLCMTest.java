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
public class NumberOperationsLCMTest {
	
	private int x;
	private int y;
	private int expectedResult;
	private NumberOperations numberObject;

	@Before
	public void initialize() {
		numberObject = new NumberOperations();
	}

	public NumberOperationsLCMTest(int expectedResult, int x, int y) {
		this.expectedResult = expectedResult;
		this.expectedResult = x;
		this.y = y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{24, 18, 24},
				{480, 32, 60},
				{330, 33, 30}
				});
	}

	@Test
	public void clumpTest() {
		assertEquals(expectedResult, numberObject.computeLCM(x, y));
	}

}
