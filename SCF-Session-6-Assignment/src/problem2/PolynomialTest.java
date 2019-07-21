package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PolynomialTest {
	
	private Polynomial polynomial;
	
	//This method tests degreeOfPolynomial method
	@Test
	public void testDegreeOfPolynomial1()
	{
		int[] polynomialCoefficients = {6,4,2};
		polynomial = new Polynomial(polynomialCoefficients);
		assertEquals(2, polynomial.degreeOfPolynomial());
	}
	@Test(expected = AssertionError.class) //Negative Test Case
	public void testDegreeOfPolynomial2()
	{
		int[] polynomialCoefficients = {};
		polynomial = new Polynomial(polynomialCoefficients);
		assertEquals(2, polynomial.degreeOfPolynomial());
	}
	
	//This method tests evaluatePolynomial method
	@Test
	public void testEvaluatePolynomial1()
	{
		int[] polynomialCoefficients = {6,4,2};
		polynomial = new Polynomial(polynomialCoefficients);
		assertEquals((float) 22.0, polynomial.evaluatePolynomial((float) 2.0),
				(float) 0.0);
	}
	@Test(expected = AssertionError.class)//Negative Test Case
	public void testEvaluatePolynomial2()
	{
		int[] polynomialCoefficients = {};
		polynomial = new Polynomial(polynomialCoefficients);
		assertEquals((float)22.0, polynomial.evaluatePolynomial((float)2.0), (float)0.0);
	}
	
	//This method tests addPolynomial method
	@Test
	public void testAddPolynomial1()
	{
		int[] inputCoefficient = { 6, 4, 2 };
		int[] anotherCoefficient = { 6, 0, 4, 2 };

		String sumOfPolynomials = "2x^3+6x^2+4x^1+12";

		Polynomial inputPolynomial1 = new Polynomial(inputCoefficient);
		Polynomial inputPolynomial2 = new Polynomial(anotherCoefficient);
		assertEquals(sumOfPolynomials, inputPolynomial1.addPolynomial(inputPolynomial2));
	}
	@Test(expected = AssertionError.class)//Negative Test Case
	public void testAddPolynomial2()
	{
		int[] inputCoefficient1 = {};
		int[] inputCoefficient2 = { 6, 0, 4, 2 };

		String sumOfPolynomials = "2x^3+6x^2+4x^1+12";

		Polynomial inputPolynomial1 = new Polynomial(inputCoefficient1);
		Polynomial inputPolynomial2 = new Polynomial(inputCoefficient2);
		
		assertEquals(sumOfPolynomials, inputPolynomial1.addPolynomial(inputPolynomial2));
	}
	
	//This method tests multiplyPolynomial method
	@Test
	public void testMultiplyPolynomial1()
	{
		int[] inputCoefficient1 = { 5, 0, 10, 6 };
		int[] inputCoefficient2 = { 1, 2, 4 };

		String multipliedPloynomial = "24x^5+52x^4+26x^3+30x^2+10x^1+5";
		
		Polynomial inputPolynomial1 = new Polynomial(inputCoefficient1);
		Polynomial inputPolynomial2 = new Polynomial(inputCoefficient2);

		assertEquals(multipliedPloynomial, inputPolynomial1.multiplyPolynomial(inputPolynomial2));
	}
	@Test(expected = AssertionError.class)//Negative Test Case
	public void testMultiplyPolynomial2()
	{
		int[] inputCoefficient1 = {};
		int[] inputCoefficient2 = { 1, 2, 4 };

		String multipliedPloynomial = "24x^5+52x^4+26x^3+30x^2+10x^1+5";
		
		Polynomial inputPolynomial1 = new Polynomial(inputCoefficient1);
		Polynomial inputPolynomial2 = new Polynomial(inputCoefficient2);

		assertEquals(multipliedPloynomial, inputPolynomial1.multiplyPolynomial(inputPolynomial2));
	}
}
