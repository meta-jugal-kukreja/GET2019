package question;

/**
 * This class is for category Mammal
 * @author Jugal
 * Dated 07/23/2019
 */
public abstract class Mammal extends Animal{

	private final static String speciality = "Walks";
	private final static String category = "Mammal";
	/**
	 * Constructor to assign specialty and category
	 */
	public Mammal(String name, int age, double weight, String type)
	{
		super(name, age, weight, category, type);
	}
	
	//Getter methods
	public static String getSpeciality() {
		return speciality;
	}
	
}
