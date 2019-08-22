package question;

/**
 * This class is for category Reptile
 * @author Jugal
 * Dated 07/23/2019
 */
public abstract class Reptile extends Animal {

	private final static String speciality = "Crawling";
	private final static String category = "Reptile";
	/**
	 * Constructor to assign specialty and category
	 */
	public Reptile(String name, int age, double weight, String type)
	{
		super(name, age, weight, category, type);
	}
	
	//Getter methods
	public static String getSpeciality() {
		return speciality;
	}

}
