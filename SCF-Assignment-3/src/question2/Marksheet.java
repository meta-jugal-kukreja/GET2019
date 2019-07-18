package question2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Driver class to perform all the operations
 * @author Admin
 * Dated 07/15/2019
 */

public class Marksheet {

	public static void main(String[] args) {

		MarksheetOperations marksheetObject = new MarksheetOperations();
		Scanner inputScanner = new Scanner(System.in);
		boolean flag = true;
		int n = 0;
		System.out.print("Enter the number of students : ");
		try{
		 n = inputScanner.nextInt();
		 if(n == 0)
			 throw new ArithmeticException();   //if size of the array is 0 then there will be ArithematicException at average and percentage of students passed methods
		}
		catch(ArithmeticException e)
		{
			System.out.println("Please Enter some amount of students");
			System.exit(0);
		}
		int[] gradeArray = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Enter the grade of student " + (i + 1) + " : ");
			gradeArray[i] = inputScanner.nextInt();
		}
		
		DecimalFormat numberFormat = new DecimalFormat("#.00"); //for making the floating point value upto 2 decimal places
		
		double averageOfGrades = marksheetObject.calculateAverageOfGrades(gradeArray);
		int maxGrade = marksheetObject.calculateMaxGrade(gradeArray);
		int minGrade = marksheetObject.calculateMinGrade(gradeArray);
		double percentageStudentsPassed = marksheetObject.calculatePercentageStudentsPassed(gradeArray);
		
		System.out.println("\nAverage of all grades is : " + numberFormat.format(averageOfGrades));
		System.out.println("Maximum grade is : " + maxGrade);
		System.out.println("Minimum grade is : " + minGrade);
		System.out.println("Percenatge of students passed : " + numberFormat.format(percentageStudentsPassed) + "%");
	}

}
