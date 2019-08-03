package question3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cricket match in which the bowler is selected according to the number of balls and the match is played
 * @author Jugal
 * Dated 08/03/2019
 */
public class CricketMatch {
	
	private int numberOfBowlers;
	private int bowlsToBePlayed;
	List<Bowler> bowlersOrder;
	BowlerHeap heapObject;
	
	/**
	 * Constructor to initialize the data members
	 * @param numberOfBowlers is the number of bowlers in the match
	 * @param bowlsToBePlayed is the total number of balls Virat is going to play
	 */
	public CricketMatch(int numberOfBowlers, int bowlsToBePlayed) {
		this.bowlsToBePlayed = bowlsToBePlayed;
		this.numberOfBowlers = numberOfBowlers;
		bowlersOrder = new ArrayList<>();
		heapObject = new BowlerHeap(numberOfBowlers);
	}

	/**
	 * In this method bowler is selected and the match is played
	 * @return {List<Bowler>} list of bowlers selected
	 */
	List<Bowler> playMatch()
	{
		while(bowlsToBePlayed > 0)
		{
			Bowler bowler = heapObject.extractBowler();
			bowlsToBePlayed = bowlsToBePlayed - bowler.getNumberOfBallLeft();
			bowlersOrder.add(bowler);
		}
		return bowlersOrder;
	}
	
	/**
	 * This method add a bowler to the cricket match
	 * @param name is the name of the bowler
	 * @param balls is the number of balls the bowler has
	 */
	void addBowler(String name, int balls)
	{
		heapObject.insertBowler(new Bowler(name,balls));
	}
	
}
