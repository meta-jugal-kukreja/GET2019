package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class contains test methods to test the UniqueCharacters class methods
 * @author Jugal
 * Dated 08/02/2019
 */
public class UniqueCharactersTest {
	
	UniqueCharacters count = new UniqueCharacters(null);

	@Test
	public void testCountUniqueCharacters1() {
		int result = count.countUniqueCharacters("abcde");
		assertEquals(5, result);
	}
	
	@Test
	public void testCountUniqueCharacters2() {
		int result = count.countUniqueCharacters("abcde@123");
		assertEquals(9, result);
	}
	
	@Test
	public void testCountUniqueCharacters3() {
		int result = count.countUniqueCharacters("abcde @123");
		assertEquals(9, result);
	}
	
	@Test(expected = AssertionError.class)
	public void testCountUniqueCharacters4() {
		int result = count.countUniqueCharacters(null);
		assertEquals(null, result);
	}
	
	@Test(expected = AssertionError.class)
	public void testCountUniqueCharacters5() {
		int result = count.countUniqueCharacters(" ");
		assertEquals(null,result);
	}

}
