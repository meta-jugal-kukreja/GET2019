package problem1;


import java.util.ArrayList;
import java.util.List;

public final class InSet {

	private int[] setOfIntegers;
	private final int UNIVERSAL_SET_SIZE = 10;

	/**
	 * This method is used for initializing the set of integers 
	 * @param setOfIntegers is the array of input integers
	 */
	InSet(int[] setOfIntegers) {
		this.setOfIntegers = setOfIntegers;
	}

	/**
	 * This method checks whether an element is member of the set
	 * @param x element to be checked
	 * @return {boolean}
	 */
	public boolean isMember(int x) {
		boolean answer = false;
		int i;
		
//		assert size() < 1 : "Set size is 0";
		if(setOfIntegers.length < 1)
			throw new AssertionError("Set size is 0");
		
		for(i = 0; i < setOfIntegers.length; i++)
		{
			if(setOfIntegers[i] == x)
			{
				answer = true;
				break;
			}
		}
		return answer;
	}

	/**
	 * This method returns the size of the set
	 * @return {int} size of the set
	 */
	public int size() {
		
//		assert size() < 1 : "Set size is 0";
		if(setOfIntegers.length < 1)
			throw new AssertionError("Set size is 0");
		
		return setOfIntegers.length;
	}

	/**
	 * This method checks whether another set is subset of the original set
	 * @param anotherSet is the subset to be checked
	 * @return {boolean}
	 */
	public boolean isSubSet(InSet anotherSet) {
		int i; 
		
//		assert (size() < 1 || anotherSet.size() < 1) : "Set size is 0";
		if(setOfIntegers.length < 1 || anotherSet.size() < 1)
			throw new AssertionError("Set size is 0");

		boolean answer = true;
		for(i = 0; i < anotherSet.size(); i++)
		{
			if(!isMember(anotherSet.setOfIntegers[i]))
			{
				System.out.println();
				answer = false;
				break;
			}
		}
		return answer;
	}

	/**
	 * This method calculates the complement of the original set
	 * @return {inSet} complement of the original set Assumption is that the universal set is {1 ... 1000}
	 */
	public int[] getComplement() {
		int[] complementedSet = new int[UNIVERSAL_SET_SIZE - size() + 1];
		int i, j = 0;
		for(i = 1; i < UNIVERSAL_SET_SIZE; i++)
		{
			if(!isMember(i))
			{
				complementedSet[j] = i;
				j++;
			}
		}
		return complementedSet;
	}

	/**
	 * This method calculates the union of two sets
	 * @param s1 is the first set
	 * @param s2 is the second set
	 * @return {inSet} union of two sets
	 */
	public int[] union(InSet set2) {
		
//		assert (size() < 1 || set2.size() < 1) : "Set size is 0";
		if(size() < 1 || set2.size() < 1)
			throw new AssertionError("Set size is 0");
		
		List<Integer> unionList = new ArrayList<Integer>();
		int i;
		for(i = 0; i < size(); i++)
		{
			unionList.add(setOfIntegers[i]);
		}
		for(i = 0; i < set2.size(); i++)
		{
			if(!isMember(set2.setOfIntegers[i]))
			{
				unionList.add(set2.setOfIntegers[i]);
			}
		}
		int[] unionSet = new int[unionList.size()];
	    for (i=0; i < unionSet.length; i++)
	    {
	        unionSet[i] = unionList.get(i).intValue();
	    }
		return unionSet;
	}
}
