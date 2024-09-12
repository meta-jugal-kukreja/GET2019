package question2;

import java.util.Comparator;

/**
 * This class is used for overriding the compare method of the Comparator interface.
 * @author Jugal
 * Dated 08/09/2019
 */
public class ComparatorOverride implements Comparator<Vertex> {

	@Override
	public int compare(Vertex node1, Vertex node2) {
		
		return node1.getWeight() - node2.getWeight(); 
	}

}
