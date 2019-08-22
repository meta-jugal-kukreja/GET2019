package question;

/**
 * This class is for category Birds
 * @author Jugal
 * Dated 07/23/2019
 */
public abstract class Bird extends Animal{

	private final static String speciality = "Flying";
	private final static String category = "Bird";
	/**
	 * Constructor to assign specialty and category
	 */
	public Bird(String name, int age, double weight, String type)
	{
		super(name, age, weight, category, type);
	}
	
	//Getter methods
	public static String getSpeciality() {
		return speciality;
	}

}
