package question;

/**
 * This class contains members which represents some general characteristics of an animal such category, name, etc
 * @author Jugal
 * Dated 07/22/2019
 */
abstract class Animal {
	
	 public String animalName;
	 public int animalId = 0;
	 public double animalWeight;
	 public int animalAge;
	 public String animalCategory;
	 public String animalType;
	 
	 public abstract String getSound();

	/**
	  * The constructor only increments the id whenever its object is created
	  */
	 Animal(String name,int age, double weight, String category, String type)
	 {
		 this.animalId++;
	     this.animalName = name;
	     this.animalAge = age;
	     this.animalWeight = weight;
	     this.animalCategory = category;
	     this.animalType = type;
	 }
	 
	 public String getAnimalCategory() {
		return animalCategory;
	}

	public String getAnimalType() {
		return animalType;
	} 
	 
}
