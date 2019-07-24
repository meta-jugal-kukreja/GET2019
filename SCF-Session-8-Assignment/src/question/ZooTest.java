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
		assertEquals(true, zoo1.addAnimal("Lion", "Bhoora"));
	}
	@Test
	public void testAddAnimal2()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
		
		zoo1.addCage("Peacock", 1);
		assertEquals(true, zoo1.addAnimal("Peacock", "nini"));
		zoo1.addCage("Lion", 1);
		assertEquals(true, zoo1.addAnimal("Lion", "Babbar"));
	}
	@Test(expected = AssertionError.class)
	public void testAddAnimal3()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
		
		zoo1.addCage("Peacock", 1);
		assertEquals(true, zoo1.addAnimal("Peacock", "nini"));
		assertEquals(true, zoo1.addAnimal("Peacock", "nini"));
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
		zoo1.addAnimal("Lion", "boora");
		
		zoo1.addCage("Peacock", 1);
		zoo1.addAnimal("Peacock", "nini");
		zoo1.addAnimal("Lion", "haha");
		
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
		zoo1.addAnimal("Lion", "boora");
		
		zoo1.addCage("Peacock", 1);
		zoo1.addAnimal("Peacock", "nini");
		zoo1.addAnimal("Lion", "Babbar");
		
		assertEquals(false, zoo1.removeAnimal("Lion", "hah"));
	}
	
}