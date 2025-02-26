package question1;

/**
 * This class handles the UI part of the ExpressionEvaluation class
 * @author Jugal
 * Dated 07/31/2019
 */
public class Main {

	public static void main(String[] args) {
		String infixExpression = "( 1 + 2 ) * ( 3 + 4 )";
		ExpressionEvaluation evaluationObject = new ExpressionEvaluation(infixExpression);
		String postfixExpression = evaluationObject.infixToPostfixConversion();
		
		System.out.println("Postfix conversion of " + infixExpression + " is " + "\"" + postfixExpression + "\"");
		
		System.out.println("Evaluation of " + postfixExpression + "is " +evaluationObject.evaluateExpression(postfixExpression));
	}

}