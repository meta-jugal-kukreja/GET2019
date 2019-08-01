package question3;

/**
 * This class represents a program in the college. It contains prgram name and its capacity
 * @author Jugal
 * Dated 08/01/2019
 */
public class Program {
	
	private String name;
	private int capacity;
	private int remaining;

	/**
	 * Constructor to initialize data members of the class
	 * @param name is the program name
	 * @param capacity is the program capacity
	 */
	public Program(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.remaining = capacity;
	}

	/**
	 * This method returns the name of the program
	 * @return {String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the capacity of the program
	 * @return {int}
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * This method returns the remaining capacity of the program
	 * @return {int}
	 */
	public int getRemainig() {
		return remaining;
	}

	/**
	 * This method sets the remaining capacity of the program
	 * @param remaining is the remaining capacity
	 */
	public void setRemainig(int remaining) {
		this.remaining = remaining;
	}
}
