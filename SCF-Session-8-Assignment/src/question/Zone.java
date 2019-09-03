package question;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is for the zones in the ZOO. The zones contains cages as a ArrayList in the ZOO.
 * @author Jugal
 * Dated 07/24/2019
 */
public class Zone {
	
	static int zoneId = 0;
	String zoneCategory;
	int zoneCapacity;
	boolean hasPark;
	boolean hasCanteen;
	public List<Cage> cageList = new ArrayList<>();
	
	/**
	 * Constructor for initializing the Zone type object
	 * @param category is the category of the zone
	 * @param capacity is the capacity of the zone
	 * @param hasPark is the boolean variable which tells whether the zone has park or not
	 * @param hasCanteen is the boolean variable which tells whether the zone has park or not
	 */
	public Zone(String category, int capacity, boolean hasPark, boolean hasCanteen)
	{
		zoneCategory = category;
		zoneCapacity = capacity;
		zoneId++;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}
	
}
