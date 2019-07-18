package question1;

/**
 * This class contains the methods for computing HCF and LCM
 * @author Jugal
 * Dated 07/18/2019
 */
public class NumberOperations {
	
	private int lcmValue = 1;
	
	/**
	 * This method computes HCF of two numbers using Euclid's Algorithm
	 * @param x is the first number
	 * @param y is the second number
	 * @return {int} HCF of two numbers
	 */
	public int computeHCF(int x, int y)
	{
		/*
		 * First check which number is greater than implement the algorithm.
		 * Because Euclid's Algorithm calculates remainder of 2 values.
		 */
		if(x > y)
		{
			if(y == 0)
				return x;
			return computeHCF(y, (x % y));
		}
		else
		{
			if(x == 0)
				return y;
			return computeHCF(x, (y % x));
		}
	}
	
	/**
	 * This method computes LCM of two numbers
	 * @param x is the first number
	 * @param y is the second number
	 * @return {int} LCM of two numbers
	 */
	public int computeLCM(int x, int y)
	{
		if (x <= 0 || y <= 0) {
			throw new ArithmeticException("Number is not positive");
		}

	    if ((lcmValue % x == 0) && (lcmValue % y == 0))
	    {
	        return lcmValue;
	    }
	    lcmValue++;
	    return computeLCM(x, y);
	}

}
