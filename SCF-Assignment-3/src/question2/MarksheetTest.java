package question2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MarksheetTest {

	private MarksheetOperations marksheetObject;

	@Before
	public void initialize() {
		marksheetObject = new MarksheetOperations();
	}

	// This method tests calculateAverageOfGrades methods
	@Test
	public void calculateAverageOfGradesTest() {
		int[] gradeArray = { 85, 96, 32, 75 };
		assertEquals(72.0,
				(double) marksheetObject.calculateAverageOfGrades(gradeArray),
				(double) 0.0);
	}

	// This method tests calculateMaxGrade methods
	@Test
	public void calculateMaxGradeTest() {
		int[] gradeArray = { 85, 96, 32, 75 };
		assertEquals(96, marksheetObject.calculateMaxGrade(gradeArray));
	}

	// This method tests calculateMinGrade methods
	@Test
	public void calculateMinGradeTest() {
		int[] gradeArray = { 85, 96, 32, 75 };
		assertEquals(32, marksheetObject.calculateMinGrade(gradeArray));
	}

	// This method tests calculateAverageOfGrades methods
	@Test
	public void calculatePercentageStudentsPassedTest() {
		int[] gradeArray = { 85, 96, 32, 75 };
		assertEquals(75.0,
				(double) marksheetObject
						.calculatePercentageStudentsPassed(gradeArray),
				(double) 0.0);
	}
}
