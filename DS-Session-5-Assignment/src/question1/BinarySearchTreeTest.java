package question1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of BinarySearchTree class
 * @author Jugal
 * Dated 08/06/2019
 */
public class BinarySearchTreeTest {
	
	JSONParser parser = new JSONParser();
    List<Data> sortedAccordingToKeys = new ArrayList<>();
    JSONObject obj = null;
    BinarySearchTree bst = null;
	
    @Before
    public void initialize() throws ParseException
    {
    	try {
            obj = (JSONObject) parser.parse(new FileReader("C:/Users/Jugal/Desktop/GET2019/DS-Session-5-Assignment/src/question1/input.json.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ");
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("File I/O Exception ");
            e.printStackTrace();
        }
    }
    
    @Test
	public void testCreationAndSortingOfTree()
	{
    	bst = new BinarySearchTree(obj);
    	assertEquals("apple", bst.sortedKeyValuePair().get(0).getKey());
    	assertEquals("cat", bst.sortedKeyValuePair().get(1).getKey());
	}
    
    @Test
	public void testDeletionInTree()
	{
    	bst = new BinarySearchTree(obj);
    	bst.deleteKeyValuePair("cat");
    	assertEquals("apple", bst.sortedKeyValuePair().get(0).getKey());
    	assertEquals("cricket", bst.sortedKeyValuePair().get(1).getKey());
	}
    
   @Test
   	public void testGetValueAtKey()
   	{
       	bst = new BinarySearchTree(obj);
       	assertEquals("game", bst.getValueAtKey("cricket"));
       	assertEquals("fruit", bst.getValueAtKey("mango"));
   	}
   
   @Test
	public void testCreationAndSortingOfTreeBetweenTwoKeys()
	{
   		bst = new BinarySearchTree(obj);
   		assertEquals("cricket", bst.sortBetweenTwoKeyValue("cricket", "nest").get(0).getKey());
   		assertEquals("mango", bst.sortBetweenTwoKeyValue("cricket", "nest").get(2).getKey());
   		assertEquals("nest", bst.sortBetweenTwoKeyValue("cricket", "nest").get(4).getKey());
	}

}
