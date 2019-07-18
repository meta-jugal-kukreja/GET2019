package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This class is used to test the NumberOperations class
 * @author Jugal
 *
 */
public class NumberOperationsTest {
	
	private NumberOperations numberObject;

	/**
	 * This method creates object before the tests begin
	 */
	@Before
	public void initialize() {
		numberObject = new NumberOperations();
	}

	/**
	 * These tests are performed on HCF
	 */
	@Test
	public void testHCF1() {
		int x = 180;
		int y = 270;
		assertEquals(90, numberObject.computeHCF(x, y));
	}
	@Test
	public void testHCF2() {
		int x = 300;
		int y = 396;
		assertEquals(12, numberObject.computeHCF(x, y));
	}
	@Test
	public void testHCF3() {
		int x = 98;
		int y = 56;
		assertEquals(14, numberObject.computeHCF(x, y));
	}
	@Test(expected=AssertionError.class) //Negative test case
	public void testHCF4() {
		int x = 98;
		int y = 0;
		assertEquals(0, numberObject.computeHCF(x, y));
	}
	
	/**
	 * These tests are performed on LCM
	 */
	@Test
	public void testLCM1() {
		int x = 18;
		int y = 24;
		assertEquals(72, numberObject.computeLCM(x, y));
	}
	@Test
	public void testLCM2() {
		int x = 32;
		int y = 60;
		assertEquals(480, numberObject.computeLCM(x, y));
	}
	@Test
	public void testLCM3() {
		int x = 33;
		int y = 30;
		assertEquals(330, numberObject.computeLCM(x, y));
	}
	@Test(expected=ArithmeticException.class) //negative test case
	public void testLCM4() {
		int x = 0;
		int y = 24;
		assertEquals(72, numberObject.computeLCM(x, y));
	}
}
