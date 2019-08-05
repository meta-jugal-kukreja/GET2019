package question1;

import java.util.List;
import org.json.simple.JSONObject;

/**
 * This class represents the Binary Search Tree for the given Dictionary
 * @author Jugal
 *
 */
public class BinarySearchTree implements Dictionary {
	
	private Node root;
	
	/**
	 * Constructor to add data from the JSON File
	 * @param object is the whole JSON object
	 */
	public BinarySearchTree(JSONObject object) {
		this.root = null;
        for (Object key : object.keySet()) {
        	addKeyValuePair(String.valueOf(key).toLowerCase(), (String)object.get(key));
        }
	}

	 /**
     * This method adds node to a tree
     * @param key is the key
     * @param value is the value of the key
     * @return true if tree node is added successfully else false
     */
	@Override
	public void addKeyValuePair(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	 /**
     * This method deletes a node with a given key
     * @param key is the key to be deleted
     */
	@Override
	public void deleteKeyValuePair(String key) {
		// TODO Auto-generated method stub
		
	}

	/**
     * This method returns the value mapped to the given key
     * @param key whose value is to be search
     * @return {String} the value mapped to the given key
     */
	@Override
	public String getValueAtKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * This method returns the sorted list of key value pair
     * @return {List<Data>}
     */
	@Override
	public List<Data> sortedOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	 /**
     * This method returns the list of sorted nodes between the given two key values
     * @param key1 is smaller than key
     * @param key2 requires to greater than key
     * @return {List<Data>} list of sorted nodes between keys
     */
	@Override
	public List<Data> sortBetweenTwoKeyValue(String key1, String key2) {
		// TODO Auto-generated method stub
		return null;
	}

}
