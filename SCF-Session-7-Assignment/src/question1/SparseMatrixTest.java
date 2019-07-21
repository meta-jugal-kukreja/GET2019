package question1;

import org.junit.Test;

public class SparseMatrixTest {
	
	@Test
	public void testMethods()
	{
		int[][] matrix1 = {{ 1, 0, 0, 0 }, { 0, 0, 10, 12 }, { 1, 0, 0, 2 }, { 0, 0, 0, 0 } };
		int[][] matrix2 = {{ 1, 0, 0, 0 }, { 0, 2, 5, 0 }, { 0, 0, 1, 0 }, { 0, 8, 0, 0 }};
		SparseMatrix sparse1 = new SparseMatrix(matrix1);
		SparseMatrix sparse2 = new SparseMatrix(matrix2);
		//int[][] result = sparse.transposeOfSparseMatrix();
		//System.out.println(sparse.isSparseMatrixSymmetric());
		int[][] result = sparse1.addTwoSparseMatrices(matrix2);
		System.out.println("In test method : ");
		sparse2.printMatrix(result);
		
	}

}
