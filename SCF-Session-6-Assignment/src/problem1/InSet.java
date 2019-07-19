package problem1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InSet {

	private int[] setOfIntegers;
	private final int UNIVERSAL_SET_SIZE = 10;

	/**
	 * This method is used for initializing the set of integers 
	 * @param setOfIntegers is the array of input integers
	 */
	void setSetOfIntegers(int[] setOfIntegers) {
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
		if(setOfIntegers.length < 1)
			throw new AssertionError("Set size is 0");
		return setOfIntegers.length;
	}

	/**
	 * This method checks whether another set is subset of the original set
	 * @param s is the subset to be checked
	 * @return {boolean}
	 */
	public boolean isSubSet(InSet anotherSet) {
		int i; 
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
		List<Integer> complementElementList = new ArrayList<>();
		int i;
		for(i = 1; i < UNIVERSAL_SET_SIZE; i++)
		{
			if(!isMember(i))
			{
				complementElementList.add(i);
			}
		}
		int[] complementedSet = new int[complementElementList.size()];
	    for (i=0; i < complementedSet.length; i++)
	    {
	        complementedSet[i] = complementElementList.get(i).intValue();
	    }
		return complementedSet;
	}

	/**
	 * This method calculates the union of two sets
	 * @param s1 is the first set
	 * @param s2 is the second set
	 * @return {inSet} union of two sets
	 */
	public int[] union(InSet set1, InSet set2) {
		if(set1.size() < 1 || set2.size() < 1)
			throw new AssertionError("Set size is 0");
		List<Integer> unionList = new ArrayList<Integer>();
		int i;
		for(i = 0; i < set1.size(); i++)
		{
			unionList.add(set1.setOfIntegers[i]);
		}
		for(i = 0; i < set2.size(); i++)
		{
			if(!set1.isMember(set2.setOfIntegers[i]))
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
