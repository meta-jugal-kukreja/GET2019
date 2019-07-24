package question;

/**
 * This class is for Snake type animals
 * @author Jugal
 * Dated 07/24/2019
 */
public class Snake extends Reptile {
	
	/**
	 * Constructor to initialize the object
	 * @param name is the name of the animal
	 * @param type is the type of the animal
	 * @param category is the category of the animal
	 */
	public Snake(String name, String type, String category) {
		
		this.animalName = name;
		this.category = category;
		this.animalType = type;
	}
	
	@Override
	public String getSound() {
		return "Hiss";
	}
	
}
