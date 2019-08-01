package question3;

/**
 * This class represents a student. It contains the student's name and his/her program preferences 
 * @author Jugal
 * Dated 08/01/2019
 */
public class Student {

	private String name;
	private String[] preferredSubjects;
	private String allocatedProgram;

	/**
	 * Constructor to initialize data members of the class
	 * @param name is the student name
	 * @param preferredSubjects is the preferred subjects of the student
	 */
	public Student(String name, String[] preferredSubjects, String allocatedProgram) {
		this.name = name;
		this.preferredSubjects = preferredSubjects;
		this.allocatedProgram = allocatedProgram;
	}

	/**
	 * This method returns the name of the allocated program of the student
	 * @return {String}
	 */
	public String getAllocatedProgram() {
		return allocatedProgram;
	}

	/**
	 * This method returns the preferred programs of the student
	 * @return {String[]}
	 */
	public String[] getPreferredPrograms() {
		return this.preferredSubjects;
	}

	/**
	 * This method returns the name of the student
	 * @return {String}
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method sets the allocated program of the student
	 * @param allocatedProgram is the name of the allocated program
	 */
	public void setAllocatedProgram(String allocatedProgram) {
		this.allocatedProgram = allocatedProgram;
	}
}
