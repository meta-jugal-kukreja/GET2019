package Question1;

import java.util.Scanner;

public class MyStringOperations {
	
	public int stringCompare()
	{
		String firstString, secondString;
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("\nEnter first string : ");
		firstString = inputScanner.next().toLowerCase();
		System.out.print("Enter second string : ");
		secondString = inputScanner.next().toLowerCase();
		if(firstString.length() != secondString.length())
			return 0;
		else
		{
			for(int i = 0; i  < firstString.length(); i++)
			{
				if(firstString.charAt(i) != secondString.charAt(i))
				{
					return 0;
				}
			}
		}
		return 1;
	}
	
	public String stringReverse()
	{
		String string;
		return null;
	}
	
	public String stringReverseCharacters()
	{
		String string;
		return null;
	}

	public String findLargetestWord()
	{
		String string;
		return null;
	}
}
