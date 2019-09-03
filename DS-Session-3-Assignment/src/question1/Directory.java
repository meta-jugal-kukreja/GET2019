package question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Directory class storing information about a directory such as Directory name, 
   date of creation and the list of sub-directories
 * @author admin
 * Dated 08/04/2019
 */
public class Directory {

	private String directoryName;
	private Date dateOfCreation;
	private Directory parentDirectory;
	private List<Directory> listOfSubDirectory;

	/**
	 * Constructor to initialize the data members of the class
	 * @param directoryName is the name of the directory
	 * @param dateOfCreation is the date at which the directory is created
	 */
	public Directory(String directoryName, Date dateOfCreation, Directory parentDirectory) {
		this.dateOfCreation = dateOfCreation;
		this.directoryName = directoryName;
		this.parentDirectory = parentDirectory;
		this.listOfSubDirectory = new ArrayList<Directory>();
	}

	public Directory getParentDirectory() {
		return parentDirectory;
	}

	/**
	 * This method returns the list of sub-directories
	 * @return {List<Directory>}
	 */
	public List<Directory> getListOfSubDirectory() {
		return listOfSubDirectory;
	}

	
	public void setListOfSubDirectory(List<Directory> listOfSubDirectory) {
		this.listOfSubDirectory = listOfSubDirectory;
	}

	/**
	 * This method returns the directory name
	 * @return {String}
	 */
	public String getName() {
		return directoryName;
	}	

	/**
	 * This method returns the date at which the directory was created
	 * @return {Date}
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

}
