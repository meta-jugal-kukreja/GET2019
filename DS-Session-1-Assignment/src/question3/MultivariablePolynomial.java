package question3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a multivariable polynomial using nested lists with 
 * @author Jugal
 * Dated 07/30/2019
 */
public class MultivariablePolynomial {
	
	List<Term> multivariablePolynomial = new ArrayList<>();
	
	public MultivariablePolynomial(List<Term> termList) {
		
		this.multivariablePolynomial = termList;
	}
	
	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * @return {int} degree of the multivariable polynomial
	 */
	int calculatePolynomialDegree()
	{
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for(Term term : multivariablePolynomial)
		{
			variablePowerSum = 0;
			for(Variable variable : term.variableList)
			{
				variablePowerSum += variable.getVariablePower();
			}
			if(degreeOfPolynomial < variablePowerSum)
				degreeOfPolynomial = variablePowerSum;
		}
		return degreeOfPolynomial;
	}
	
	/**
	 * This method visualises the Multivariable polynomial into string
	 * @return {String} Multivariable Polynomial
	 */
	String visualiseMultivariablePolynomial()
	{
		String polynomialString = "";
		for(Term term : multivariablePolynomial)
		{
			polynomialString = polynomialString + term.termCoefficient;
			for(Variable variable : term.variableList)
			{
				polynomialString = polynomialString + "*" + variable.getVaribleName() + "^" + variable.getVariablePower();
			}
			if(term != multivariablePolynomial.get(multivariablePolynomial.size() - 1))
				polynomialString = polynomialString + " + ";
		}
		
		return polynomialString;
	}

}
