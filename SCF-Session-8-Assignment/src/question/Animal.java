package question;

/**
 * This class contains members which represents some general characteristics of an animal such category, name, etc
 * @author Jugal
 * Dated 07/22/2019
 */
abstract class Animal {
	
	 public String animalName;
	 public int animalId = 0;
	 public String category;
	 public String speciality;
	 public double animalWeight;
	 public int animalAge;
	 public String animalType;
	 
	 public abstract String getSound();
	 
	 /**
	  * The constructor only increments the id whenever its object is created
	  */
	 Animal()
	 {
		 animalId++;
	 }

}
