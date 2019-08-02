package question3;

/**
 * This class stores the information about a bowler such as his name and his number of balls left
 * @author Jugal
 * Dated 08/02/2019
 */
public class Bowler {
	
	String bowlerName;
	int numberOfBallLeft;
	
	/**
	 * Constructor to initialize the data members
	 * @param bowlerName is the name of the bowler
	 * @param numberOfBallsLeft is the number of balls left with the bowler
	 */
	Bowler(String bowlerName, int numberOfBallsLeft)
	{
		this.bowlerName = bowlerName;
		this.numberOfBallLeft = numberOfBallsLeft;
	}

	/**
	 * This method returns the bowler's name
	 * @return {String} bowler's name
	 */
	public String getBowlerName() {
		return bowlerName;
	}

	/**
	 * This method returns the number of balls left with the bowler
	 * @return {int} number of balls left
	 */
	public int getNumberOfBallLeft() {
		return numberOfBallLeft;
	}

}
