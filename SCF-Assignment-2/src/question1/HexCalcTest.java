package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HexCalcTest {

	private HexCalc hexCalcObject;

	//This method creates object before the tests begin
	@Before
	public void initialize() {
		hexCalcObject = new HexCalc();
	}

	//These tests are performed on convert hexadecimal to decimal
	@Test
	public void convertHexadecimalToDecimalTest1() {
	
		assertEquals(175, hexCalcObject.convertHexadecimalNumberToDecimalNumber("AF"));
	}
	@Test(expected = AssertionError.class)
	public void convertHexadecimalToDecimalTest2() {
	
		assertEquals(175, hexCalcObject.convertHexadecimalNumberToDecimalNumber("AM"));
	}
	
	//This test is performed on convert decimal to hexadecimal
	@Test
	public void convertDecimalToHexadecimalTest1() {
	
		assertEquals("AF", hexCalcObject.convertDecimalNumberToHexadecimalNumber(175));
	}
	
	//These tests are performed on addition on two hexadecimal numbers method
	@Test
	public void addHexadecimalNumbersTest1() {
	
		assertEquals("16B", hexCalcObject.addTwoHexadecimalNumbers("AF","BC"));
	}
	@Test(expected = AssertionError.class)
	public void addHexadecimalNumbersTest2() {
	
		assertEquals("", hexCalcObject.addTwoHexadecimalNumbers("AM","BC"));
	}
	
	//These tests are performed on subtraction on two hexadecimal numbers method
	@Test
	public void subtractHexadecimalNumbersTest1() {
	
		assertEquals("D", hexCalcObject.subtractTwoHexadecimalNumbers("BC","AF"));
	}
	@Test(expected = AssertionError.class)
	public void subtractHexadecimalNumbersTest2() {
	
		assertEquals("", hexCalcObject.subtractTwoHexadecimalNumbers("AM","BC"));
	}
	
	//These tests are performed on multiplication on two hexadecimal numbers method
	@Test
	public void multiplyHexadecimalNumbersTest1() {
	
		assertEquals("8084", hexCalcObject.multiplyTwoHexadecimalNumbers("AF","BC"));
	}
	@Test(expected = AssertionError.class)
	public void multiplyHexadecimalNumbersTest2() {
	
		assertEquals("", hexCalcObject.multiplyTwoHexadecimalNumbers("AM","BC"));
	}
	
	//These tests are performed on division on two hexadecimal numbers method
	@Test
	public void divideHexadecimalNumbersTest1() {
	
		assertEquals("1", hexCalcObject.divideTwoHexadecimalNumbers("BC","AF"));
	}
	@Test(expected = AssertionError.class)
	public void divideHexadecimalNumbersTest2() {
	
		assertEquals("", hexCalcObject.divideTwoHexadecimalNumbers("AM","BC"));
	}
	
	//These tests are performed to check equality of two hexadecimal numbers
	@Test
	public void hexadecimalNumberEqualityTest1() {
	
		assertEquals(false, hexCalcObject.checkEqualityOfTwoHexadecimalNumbers("BC","AF"));
	}
	@Test
	public void hexadecimalNumberEqualityTest2() {
	
		assertEquals(true, hexCalcObject.checkEqualityOfTwoHexadecimalNumbers("AF","AF"));
	}
	
	//These tests are performed to check whether first hexadecimal number is greater than another
	@Test
	public void firstNumberGreaterTest1() {
	
		assertEquals(true, hexCalcObject.isFirstGreater("BC","AF"));
	}
	@Test
	public void firstNumberGreaterTest2() {
	
		assertEquals(false, hexCalcObject.isFirstGreater("AF","BC"));
	}

	//These tests are performed to check whether first hexadecimal number is smaller than another
	@Test
	public void firstNumberSmallerTest1() {
	
		assertEquals(false, hexCalcObject.isFirstSmaller("BC","AF"));
	}
	@Test
	public void firstNumberSmallerTest2() {
	
		assertEquals(true, hexCalcObject.isFirstSmaller("AF","BC"));
	}
	@Test(expected = AssertionError.class)
	public void firstNumberSmallerTest3() {
	
		assertEquals(false, hexCalcObject.isFirstSmaller("AM","BC"));
	}
}
