package question1;

import org.junit.Test;
import static org.junit.Assert.*;

public class SparseMatrixTest {
	
	//This methods tests transpose method
	@Test
	public void testTranspose1() {
		int[][] inputMatrix = { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } };
		SparseMatrix sparseMatrix = new SparseMatrix(inputMatrix);
		int transposeResult[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		assertArrayEquals(transposeResult, sparseMatrix.transposeOfSparseMatrix());
	}
	@Test(expected = AssertionError.class)
	public void testTranspose2() {
		int[][] inputMatrix = {{}};
		SparseMatrix sparseMatrix = new SparseMatrix(inputMatrix);
		int transposeResult[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		assertArrayEquals(transposeResult, sparseMatrix.transposeOfSparseMatrix());
	}

	//This methods tests isSymmetric method
	@Test
	public void testIsSymmetric1() {
		SparseMatrix sparseMatrix = new SparseMatrix(
				new int[][] { { 4, 0, 0 }, { 0, 1, 0 }, { 0, 0, 5 } });
		assertEquals(true, sparseMatrix.isSparseMatrixSymmetric());
	}
	@Test
	public void testIsSymmetric2() {
		SparseMatrix sparseMatrix = new SparseMatrix(
				new int[][] { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } });
		assertEquals(false, sparseMatrix.isSparseMatrixSymmetric());
	}


	//This methods tests addSparseMatrices method
	@Test
	public void testAdd1() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 0 }, { 0, 0, 10 } };
		SparseMatrix spareMatrix1 = new SparseMatrix(matrix1);
		SparseMatrix spareMatrix2 = new SparseMatrix(matrix2);
		assertArrayEquals(addResult, spareMatrix1.addTwoSparseMatrices(matrix2));
	}
	@Test
	public void testAdd2() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 8 }, { 2, 0, 10 } };
		SparseMatrix spareMatrix1 = new SparseMatrix(matrix1);
		SparseMatrix spareMatrix2 = new SparseMatrix(matrix2);
		assertArrayEquals(addResult, spareMatrix1.addTwoSparseMatrices(matrix2));
	}
	@Test(expected = AssertionError.class)
	public void testAdd3() {
		int matrix1[][] = {{}};
		int matrix2[][] = {{}};
		int addResult[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		SparseMatrix spareMatrix1 = new SparseMatrix(matrix1);
		SparseMatrix spareMatrix2 = new SparseMatrix(matrix2);
		assertArrayEquals(addResult, spareMatrix1.addTwoSparseMatrices(matrix2));
	}

	//This methods tests multiplySparseMatrices method
	@Test
	public void multiplyPositiveTest() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int multiplyResult[][] = { { 16, 0, 32 }, { 0, 1, 0 }, { 0, 2, 25 } };
		SparseMatrix spareMatrix1 = new SparseMatrix(matrix1);
		SparseMatrix spareMatrix2 = new SparseMatrix(matrix2);
		assertArrayEquals(multiplyResult, spareMatrix1.multiplySparseMatrix(matrix2));
	}
	@Test(expected = AssertionError.class)
	public void multiplyNegativeTest() {
		int matrix1[][] = { { 0, 4, 0, 9 }, { 1, 0, 0, 6 }, { 2, 0, 5, 8 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int multiplyResult[][] = { { 16, 0, 32 }, { 0, 1, 0 }, { 0, 2, 25 } };
		SparseMatrix spareMatrix1 = new SparseMatrix(matrix1);
		SparseMatrix spareMatrix2 = new SparseMatrix(matrix2);
		assertEquals("unmatched matrices",spareMatrix1.multiplySparseMatrix(matrix2));
	}

}
