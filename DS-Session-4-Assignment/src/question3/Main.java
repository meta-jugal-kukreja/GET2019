package question3;

/**
 * This class handles the UI part of the MolecularMass class
 * @author Jugal
 * Dated 08/02/2019
 */
public class Main {

	public static void main(String[] args) {
	
		MolecularMass moleculeObj = new MolecularMass();
		
		System.out.println(moleculeObj.calculateMass("COH(COH)22"));
		
		System.out.println(moleculeObj.calculateMass("COH"));
		
		System.out.println(moleculeObj.calculateMass("CHOC(CH3)3"));
		
	}
}
