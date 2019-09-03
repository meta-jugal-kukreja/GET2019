package question;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for the cages in the zones
 * @author Jugal
 * Dated 07/24/2019
 */
public class Cage {
	
	 int cageCapacity;
	 List<Animal> animalList = new ArrayList<>();
	 String cageType;

	 /**
	  * Constructor to initialize the cage type object
	  * @param type is the type of the cage to be added
	  * @param capacity is the capacity of the cage to be added
	  */
	public Cage(String type, int capacity)
	{
		cageType = type;
		cageCapacity = capacity;
	}
	
}
