package question;

import java.util.Scanner;

/**
 * The main class is all the UI part of the Zoo Management System.
 * It contains methods for operations of Zoo Management System.
 * If the application is operated for the first time the user has to first add the Zone then Cage then add animal to it.
 * @author Jugal
 * Dated 07/27/2019
 */
public class Main {
	
	static Zoo zooManagement = new Zoo();

	public static void main(String[] args) {
		
		String choice;	
		boolean flag = true;
		Scanner inputScanner = new Scanner(System.in);
		
		do {
			System.out.println("\nMenu : \n");
			System.out.println("1. Add a New Zone to the Zoo.");
			System.out.println("2. Add a New Cage to the Zone.");
			System.out.println("3. Add an Animal to the Cage");
			System.out.println("4. Remove a Dead Animal");
			System.out.println("5. Display the whole Zoo");
			System.out.println("6. Exit");
			
			System.out.print("\nEnter your choice please : ");
			choice = inputScanner.nextLine();

			switch (choice) 
			{
				case "1" :	addZoneToZoo();break;
			
				case "2" :	addCageToZone();break;
			
				case "3" :	addAnimalToTheCage();break;
			
				case "4":	removeAnimalFromZoo();break;
					
				case "5" :	displayZoo(); break;
				
				case "6" :	flag = false; break;
			
				default: 	System.out.println("Wrong selection!");
			}
			
		} while (flag);
		
//		inputScanner.close();
	}

	private static void addZoneToZoo() {
		
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("\nAdd the category of the zone to be added in the Zoo : ");
		String zoneCategory = inputScanner.nextLine();
		System.out.print("Add the capacity of the zone : ");
		int zoneCapacity = inputScanner.nextInt();
		
		zooManagement.addZone(zoneCategory, zoneCapacity);
		
		System.out.println("\nZone of Category " + zoneCategory + " with capacity " + zoneCapacity + " is added.");
		
		
//		inputScanner.close();
	}

	private static void addCageToZone() {

		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("\nAdd the type of the cage to be added in the Zone : ");
		String cageType = inputScanner.nextLine();
		System.out.print("Add the capacity of the cage : ");
		int cageCapacity = inputScanner.nextInt();
		
		zooManagement.addCage(cageType, cageCapacity);
		
		System.out.println("\nCage of type " + cageType + " with capacity " + cageCapacity + " is added.");
		
		//inputScanner.close();
	}

	private static void addAnimalToTheCage() {

		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("\nAdd the type of the animal to be added in the Cage : ");
		String animalType = inputScanner.nextLine();
		System.out.print("Add the name of the Animal : ");
		String animalName = inputScanner.nextLine();
		
		if(zooManagement.addAnimal(animalType, animalName))
			System.out.println("Animal of type " + animalType + " of name " + animalName + " is added.");
		else
			System.out.println("Animal was not added");
		
	}
	
	private static void removeAnimalFromZoo() {

		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("Add the type of the animal which is dead : ");
		String animalType = inputScanner.nextLine();
		System.out.print("Add the name of the Animal : ");
		String animalName = inputScanner.nextLine();
		
		if(zooManagement.removeAnimal(animalType, animalName))
			System.out.println("\nAnimal of type " + animalType + " of name " + animalName + " is remove.");
		else
			System.out.println("Animal was not removed");

	}
	
	private static void displayZoo() {
		
		int i,j,k;
		
		System.out.println("\nZoo:");
		for(i = 0; i < zooManagement.zoneList.size(); i++)
		{
			System.out.println("\nZone " + (i + 1) + " :");
			Zone zone = zooManagement.zoneList.get(i);
			for(j = 0; j < zone.cageList.size(); j++)
			{
				System.out.println("\t Cage " + (j + 1) + " : ");
				Cage cage = zone.cageList.get(j);
				for(k = 0; k < cage.animalList.size(); k++)
				{
					Animal animal = cage.animalList.get(k);
					System.out.println("\t\tAnimal " + (k + 1) + " : ");
					System.out.println("\t\tAnimal Name : " + animal.animalName);
					System.out.println("\t\tAnimal Type : " + animal.animalType);
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
