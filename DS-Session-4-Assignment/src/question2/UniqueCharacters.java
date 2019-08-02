package question2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to count the number of unique characters in a string and
 * cache to store previous string result
 * 
 * @author admin
 *
 */

public class UniqueCharacters {

	private Map<String,Integer> cacheMap;
	
	void setCache(Map<String, Integer> cacheMap) {
		this.cacheMap = cacheMap;
	}
	
	UniqueCharacters() {
		
		this.cacheMap=new HashMap<String, Integer>();
	}
	
	/**
	 * This method to counts the number of unique characters in a string
	 * @param inputString is the string to be checked
	 * @return {int} number of unique characters
	 */
	int countUniqueCharacters(String inputString){
		
		Set<Character> uniqueCharSet=new HashSet<Character>();
		
		if(inputString==null || inputString.equals(" ")){
			
			throw new AssertionError("input string is invalid");
			
		}
		else{
			if(cacheMap.containsKey(inputString)){
				return cacheMap.get(inputString);
			}
			else{
				
				inputString=inputString.toLowerCase();
				
				for(int i=0;i<inputString.length();++i){
					
					char charAtIndex=inputString.charAt(i);
					
					if(charAtIndex==' '){
						continue;
					}
					else{
						if(!uniqueCharSet.contains(charAtIndex)){
							uniqueCharSet.add(charAtIndex);
						}
					}
				}
			}
		}
		cacheMap.put(inputString, uniqueCharSet.size());
		return uniqueCharSet.size();
	}
	
}