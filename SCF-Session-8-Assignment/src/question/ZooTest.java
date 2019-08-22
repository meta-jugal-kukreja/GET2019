package question;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZooTest
{
	//These tests test the addAnimal method
	@Test
	public void testAddAnimal1()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Lion", 3);
		assertEquals(true, zoo1.addAnimal("Lion", "Bhoora", 25, 50.0));
	}
	@Test
	public void testAddAnimal2()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
		
		zoo1.addCage("Peacock", 1);
		assertEquals(true, zoo1.addAnimal("Peacock", "nini", 10, 10.0));
		zoo1.addCage("Lion", 1);
		assertEquals(true, zoo1.addAnimal("Lion", "Babbar", 25, 56.0));
	}
	@Test(expected = AssertionError.class)
	public void testAddAnimal3()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
		
		zoo1.addCage("Peacock", 1);
		assertEquals(true, zoo1.addAnimal("Peacock", "nini",10, 10.0));
		assertEquals(true, zoo1.addAnimal("Peacock", "nini",10, 10.0));
	}
	
	//These tests test the removeAnimal method
	@Test
	public void testRemoveAnimal1()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Lion", 3);
		zoo1.addAnimal("Lion", "boora", 20, 60.0);
		
		zoo1.addCage("Peacock", 1);
		zoo1.addAnimal("Peacock", "nini", 10, 10.0);
		zoo1.addAnimal("Lion", "haha", 25, 56.0);
		
		assertEquals(true, zoo1.removeAnimal("Lion", "haha"));
	}
	@Test
	public void testRemoveAnimal2()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Lion", 3);
		zoo1.addAnimal("Lion", "boora", 30, 41.0);
		
		zoo1.addCage("Peacock", 1);
		zoo1.addAnimal("Peacock", "nini", 10, 10.0);
		zoo1.addAnimal("Lion", "Babbar", 36, 70.0);
		
		assertEquals(false, zoo1.removeAnimal("Lion", "hah"));
	}
	
}