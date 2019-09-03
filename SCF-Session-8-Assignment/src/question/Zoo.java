package question;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main ZOO management class which contains all the methods to add and remove animal, cage and zone.
 * @author Jugal
 * Dated 07/24/2019
 */
public class Zoo {

	List<Zone> zoneList = new ArrayList<>();
	
	/**
	 * This method creates a new zone in the Zoo
	 * @param zoneCategory is the category of the zone to be created
	 * @param ZoneCapacity is the capacity of the zone to be created
	 */
	public void addZone(String zoneCategory, int ZoneCapacity)
	{
		zoneList.add(new Zone(zoneCategory, ZoneCapacity, true,true));
	}
	
	/**
	 * This method creates a new cage in the zone
	 * @param cageType is the type of the cage to be created
	 * @param cageCapacity is the capacity of the cage to be created
	 */
	public void addCage(String cageType, int cageCapacity)
	{
		int i;
		for(i = 0; i < zoneList.size(); i++)
		{
			if(zoneList.get(i).zoneCategory.equals(getCategory(cageType)) && zoneList.get(i).zoneCapacity > zoneList.get(i).cageList.size())
			{
				zoneList.get(i).cageList.add(new Cage(cageType, cageCapacity));
				break;
			}
		}
		
		assert i == zoneList.size() : "Cage cannot be created";
	}
	
	/**
	 * This is the helper method which calculates the category of the animal type
	 * @param type is the type of animal whose category is to be calculated
	 * @return {String} category of the animal type
	 */
	String getCategory(String type)
	{
		String category = null;
		
		switch(type.toUpperCase())
		{
			case "LION":
				category = Lion.class.getSuperclass().getSimpleName();
				break;
			case "PEACOCK":
				category = Peacock.class.getSuperclass().getSimpleName();
				break;
			case "SNAKE":
				category = Snake.class.getSuperclass().getSimpleName();
				break;
		}
		return category;
	}
	
	/**
	 * This is the helper method used to build the Animal type object
	 * @param animalName is the animal name whose object is to be build
	 * @param animalType is the type of that animal name
	 * @return {Animal} animal object
	 */
	public Animal buildAnimalObject(String animalName, String animalType, int animalAge, double animalWeight)
	{
		Animal animalObj = null;
		switch (animalType.toLowerCase())
		{
		case "lion":
			animalObj = new Lion(animalName, animalAge, animalWeight);
			break;
		
		case "peacock":
			animalObj = new Peacock(animalName, animalAge, animalWeight);
			break;
			
		case "snake":
			animalObj = new Snake(animalName, animalAge, animalWeight);
			break;		
		}
		
		return animalObj;
	}
	
	/**
	 * This method adds the animal to the cage according to the zone category and cage type and some other conditions
	 * @param animalTypeToBeAdded is the type of animal to be added
	 * @param animalNameToBeAdded is the name of animal to be added
	 * @return {boolean}
	 */
	public boolean addAnimal(String animalTypeToBeAdded, String animalNameToBeAdded, int ageOfAnimalToBeAdded, double weightOfAnimalToBeAdded)
	{
		boolean isAnimalAdded = false;
		
		Animal animalObj = buildAnimalObject(animalNameToBeAdded, animalTypeToBeAdded, ageOfAnimalToBeAdded, weightOfAnimalToBeAdded);

		/*
		 * First traverse to zone then cage then add animal if all the conditions are met
		 */
		for(Zone zone : zoneList)
		{
			if(zone.zoneCategory.equals(animalObj.getAnimalCategory()))
			{
				for(Cage cage : zone.cageList)
				{
					if(cage.cageType.equals(animalObj.getAnimalType()) && cage.cageCapacity > cage.animalList.size())
					{
						for(Animal animal : cage.animalList)
						{
							assert animal.animalName.equals(animalNameToBeAdded) : "Animal of this name is already present";
						}
						cage.animalList.add(animalObj);
						isAnimalAdded = true;
						break;
					}
				}
				if(isAnimalAdded)
					break;
			}
		}
		
		return isAnimalAdded;
	}
	
	/**
	 * This method removes the animal from the cage according to the zone category and cage type and some other conditions
	 * Assumption : This method is called whenever an animal is dead
	 * @param animalTypeToBeAdded is the type of animal to be removed
	 * @param animalNameToBeAdded is the name of animal to be removed
	 * @return {boolean}
	 */
	public boolean removeAnimal(String animalTypeToBeRemoved, String animalNameToBeRemoved)
	{
		boolean isAnimalRemoved = false;
		/*
		 * First traverse to zone then cage then remove animal if all the conditions are met
		 */
		for(Zone zone : zoneList)
		{
			if(zone.zoneCategory.equals(getCategory(animalTypeToBeRemoved)))
			{
				for(Cage cage : zone.cageList)
				{
					if(cage.cageType.equals(animalTypeToBeRemoved))
					{
						for(Animal animal : cage.animalList)
						{
							if(animal.animalName.equals(animalNameToBeRemoved))
							{
								cage.animalList.remove(indexOfAnimalInCage(cage.animalList, animalNameToBeRemoved));
								isAnimalRemoved = true;
								break;
							}
						}
					}
					if(isAnimalRemoved)
						break;
				}
				if(isAnimalRemoved)
					break;
			}
		}
		return isAnimalRemoved;
	}
	
	/**
	 * This is the helper method which checks whether an animal is present in the cage
	 * @param animalList is the cage to be checked
	 * @param animalNameToBeChecked is the animal to be checked
	 * @return {int} if found then index of that animal in the cage else -1
	 */
	public int indexOfAnimalInCage(List<Animal> animalList, String animalNameToBeChecked)
	{
		for(int i = 0; i < animalList.size(); i++)
		{
			if(animalList.get(i).animalName.equals(animalNameToBeChecked))
			{
				return i;
			}
		}
		return -1;
	}
	
}
