package Question2;

import java.text.DecimalFormat;

/**
 * Class containing all the methods to perform all the operations.
 * @author Admin
 * Dated 07/15/2019
 */
public class MarksheetOperations {
	
	/**
	 * This method calculates the average of all the grades
	 * @param {int[]}gradeArray is the array which contains the grades of all the students
	 * @return {double}average of all grades in double
	 */
	public double calculateAverageOfGrades(int[] gradeArray)
	{
		int sumOfGrade = 0;
		for(int i : gradeArray)
			sumOfGrade = sumOfGrade + i;
		
		return ((double)sumOfGrade/gradeArray.length);
	}
	
	/**
	 * This method calculates the maximum of all the grades
	 * @param {int[]}gradeArray is the array which contains the grades of all the students
	 * @return {int}maximum grade
	 */
	public int calculateMaxGrade(int[] gradeArray)
	{
		int maxGrade = gradeArray[0];
		for(int i : gradeArray)
		{
			if(maxGrade < i)
			{
				maxGrade = i;
			}
		}
		return maxGrade;
	}

	/**
	 * This method calculates the minimum of all the grades
	 * @param {int[]}gradeArray is the array which contains the grades of all the students
	 * @return {int}minimum grade
	 */
	public int calculateMinGrade(int[] gradeArray)
	{
		int minGrade = gradeArray[0];
		for(int i : gradeArray)
		{
			if(minGrade > i)
			{
				minGrade = i;
			}
		}
		return minGrade;
	}
	
	/**
	 * This method calculates the percentage of students passed whose grade is >= 40
	 * @param {int[]}gradeArray is the array which contains the grades of all the students
	 * @return {double}percentage of students whom grade is >= 40(in double)
	 */
	public double calculatePercentageStudentsPassed(int[] gradeArray)
	{
		int sumOfStudenstPassed = 0;
		for(int i : gradeArray)
		{
			if(i >= 40)
				sumOfStudenstPassed++;
		}
		return (((double)sumOfStudenstPassed/gradeArray.length) * 100);
	}
}
