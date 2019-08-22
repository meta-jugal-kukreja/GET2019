package question;

/**
 * This class is for Lion type animals
 * @author Jugal
 *  Dated 07/24/2019
 */
public class Lion extends Mammal {

	private final static String type = "Lion";
	/**
	 * Constructor to initialize the object
	 * 
	 * @param name is the name of the animal
	 * @param type is the type of the animal
	 * @param category is the category of the animal
	 */
	public Lion(String name, int age, double weight) {
		super(name, age, weight, type);
	}

	@Override
	public String getSound() {
		return "Roar";
	}

}
