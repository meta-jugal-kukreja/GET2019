package problem2;

/**
 * This class contains the methods which are to be performed on a polynomial. As polynomials are immutable so this class is also immutable
 * @author Jugal
 * Dated 07/19/2019
 */
public class Polynomial {

	private int[] polynomials;
	private int polynomialDegree;
	
	public Polynomial(int[] polynomial, int polynomialDegree)
	{
		this.polynomials = polynomial;
		this.polynomialDegree = polynomial.length - 1;
	}
}
