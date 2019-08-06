package question1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class handles the UI part of the BinarySearchTree Class
 * @author Jugal
 * Dated 08/06/2019
 */
public class Main {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
	
        JSONParser parser = new JSONParser();
        List<Data> sortedAccordingToKeys = new ArrayList<>();
        JSONObject obj = null;
        BinarySearchTree bst = null;
        try {
            obj = (JSONObject) parser.parse(new FileReader("C:/Users/Jugal/Desktop/GET2019/DS-Session-5-Assignment/src/question1/input.json.txt"));
            bst = new BinarySearchTree(obj);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ");
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("File I/O Exception ");
            e.printStackTrace();
        }
        
        System.out.println("The tree is(sorted) : ");
        bst.printTree(bst.root);
        
        System.out.println("\n\nThe tree after deletion is : ");
        bst.deleteKeyValuePair("cat");
        bst.printTree(bst.root);
        
        System.out.println("\n\nThe value at key \"apple\" is " + bst.getValueAtKey("apple"));
        
        System.out.println("\n\nThe sorted tree between key \"cricket\" and key \"nest\" is : ");
        sortedAccordingToKeys = bst.sortBetweenTwoKeyValue("cricket", "nest");
        for(int i = 0; i < sortedAccordingToKeys.size(); i++)
        {
        	System.out.println("\"" + sortedAccordingToKeys.get(i).getKey() + "\" : " + sortedAccordingToKeys.get(i).getValue());
        }
	}

}
