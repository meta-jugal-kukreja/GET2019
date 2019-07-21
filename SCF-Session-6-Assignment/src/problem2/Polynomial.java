package problem2;

/**
 * This class contains the methods which are to be performed on a polynomial. As polynomials are immutable so this class is also immutable
 * @author Jugal
 * Dated 07/19/2019
 */
public class Polynomial {

	private int[] polynomials;
	private int polynomialDegree;
	
	/**
	 * Constructor to initialize the array and the degree
	 * @param polynomial is the input array which contains the coefficients of the input polynomial
	 */
	public Polynomial(int[] polynomial)
	{
		this.polynomials = polynomial;
		this.polynomialDegree = polynomial.length - 1;
	}
	
	/**
	 * This methods evaluates the given polynomial with the given number
	 * @param x is the number through which the polynomial is to be evaluated
	 * @return {float} evaluation of the polynomial
	 */
	public float evaluatePolynomial(float x)
	{
		if (polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}

		float evaluation = (float) 0.0;

		for (int i = polynomialDegree; i >= 0; --i) {
			evaluation += (float) (polynomials[i] * Math.pow(x, i));
		}
		return evaluation;
	}
	
	/**
	 * This method calculates the degree of the polynomial
	 * @return {int} degree of the polynomial
	 */
	public int degreeOfPolynomial()
	{
		if (polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		return polynomialDegree;
	}
	
	/**
	 * This method adds two polynomials
	 * @param inputPolynomial1 is the first polynomial number
	 * @param inputPolynomial2 is the second polynomial number
	 * @return {String} the added polynomial number
	 */
	public String addPolynomial(Polynomial inputPolynomial2) {
		if (polynomials.length < 1
				|| inputPolynomial2.polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		int maxLength = Math.max(polynomialDegree + 1,
				inputPolynomial2.polynomialDegree + 1);
		int minLength = Math.min(polynomialDegree + 1,
				inputPolynomial2.polynomialDegree + 1);
		Polynomial sum = new Polynomial(new int[maxLength]);

		for (int i = 0; i < minLength; ++i) {
			sum.polynomials[i] = polynomials[i]
					+ inputPolynomial2.polynomials[i];

		}
		if (maxLength == inputPolynomial2.polynomials.length) {
			for (int i = minLength; i < maxLength; ++i) {
				sum.polynomials[i] = inputPolynomial2.polynomials[i];
			}
		} else {
			for (int i = minLength; i < maxLength; ++i) {

				sum.polynomials[i] = polynomials[i];
			}
		}
		return getPolyString(sum);

	}
	
	/**
	 * This method multiplies two polynomials
	 * @param inputPolynomial1 is the first polynomial number
	 * @param inputPolynomial2 is the second polynomial number
	 * @return {String} the multiplied polynomial number
	 */
	public String multiplyPolynomial(Polynomial inputPolynomial2) {
		if (polynomials.length < 1
				|| inputPolynomial2.polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		Polynomial multipliedPolynomial = new Polynomial(new int[polynomialDegree
				+ inputPolynomial2.polynomialDegree + 1]);

		for (int i = 0; i <= polynomialDegree; ++i) {
			for (int j = 0; j <= inputPolynomial2.polynomialDegree; ++j) {
				multipliedPolynomial.polynomials[i + j] += polynomials[i]
						* inputPolynomial2.polynomials[j];
			}
		}

		return getPolyString(multipliedPolynomial);
	}
	
	/**
	 * This method constructs the polynomial string with the help of coefficients
	 * @param inputPolynomial is the polynomial whose string is to be constructed
	 * @return {String} Constructed String	
	 */
	public String getPolyString(Polynomial inputPolynomial) {
		if (inputPolynomial.polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		StringBuilder dispalyString = new StringBuilder();
		for (int i = inputPolynomial.polynomials.length - 1; i > 0; i--) {
			dispalyString.append(inputPolynomial.polynomials[i]
					+ "x^" + i + "+");
		}
		dispalyString.append(inputPolynomial.polynomials[0]);
		return dispalyString.toString();
	}

	
	
}
