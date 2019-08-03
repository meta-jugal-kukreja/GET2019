package question3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * This class tests the methods of CricketMatch class
 * @author Jugal
 * Dated 08/03/2019
 */
public class CricketMatchTest {
	
	@Test
	public void test1()
	{
		CricketMatch match = new CricketMatch(7, 37);
		
		match.addBowler("Dhoni", 1);
		match.addBowler("Chahal", 4);
		match.addBowler("Bhumrah", 15);
		match.addBowler("Shami", 8);
		match.addBowler("Bhuvneshwar", 9);
		match.addBowler("Kuldeep", 3);
		match.addBowler("Pollard", 2);
		
		List<Bowler> bowlersOrder = match.playMatch();
		assertEquals("Bhumrah", bowlersOrder.get(0).getBowlerName());
		assertEquals("Shami", bowlersOrder.get(2).getBowlerName());
	}
	
	@Test
	public void test2()
	{
		CricketMatch match = new CricketMatch(7, 30);
		
		match.addBowler("Dhoni", 1);
		match.addBowler("Chahal", 4);
		match.addBowler("Bhumrah", 8);
		match.addBowler("Shami", 8);
		match.addBowler("Bhuvneshwar", 10);
		match.addBowler("Kuldeep", 3);
		match.addBowler("Pollard", 2);
		
		List<Bowler> bowlersOrder = match.playMatch();
		
		assertEquals("Bhuvneshwar", bowlersOrder.get(0).getBowlerName());
		assertEquals("Bhumrah", bowlersOrder.get(1).getBowlerName());
	}

}
