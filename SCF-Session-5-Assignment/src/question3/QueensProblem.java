package question3;

/**
 * This class contains the methods which checks
 * 
 * @author Jugal 
 * Dated 07/18/2019
 */
public class QueensProblem {

	int dimension;

	public QueensProblem(int dimension) {
		this.dimension = dimension;
	}

	/**
	 * This method prints the board with all the queens if this problem is solved
	 * @param board is the 2D array which contains the arrangement of the queens
	 */
	public void printBoard(int[][] board) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	/**
	 * This method checks if the current position is safe for the current queen
	 * so that it is not attacked by the other queens and vice versa
	 * 
	 * @param board is the 2D array which contains the arrangement of the queens
	 * @param row is the row of the current queen
	 * @param column is the column of the current queen
	 * @return {boolean}
	 */
	public boolean isPositionForQueenSafe(int board[][], int row, int column) {
		int i, j;
		for (i = 0; i < column; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = column; j >= 0 && i < dimension; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	/**
	 * This method solves the N Queens problem by checking the queen's safe position and calling it recursively to correctly place it
	 * @param board is the 2D array which contains the arrangement of the queens
	 * @param column is the column of the current queen
	 * @return {boolean}
	 */
	public boolean solveNQueensProblem(int[][] board, int column) {
		if (column >= dimension) //This is the base case
			return true;
		for (int i = 0; i < dimension; i++) {
			if (isPositionForQueenSafe(board, i, column)) {
				board[i][column] = 1;
				if (solveNQueensProblem(board, column + 1) == true)
					return true;
				board[i][column] = 0; // BACKTRACK
			}
		}
		return false;
	}
	
	/**
	 * This method checks for assertion error and starts the solution for N queens problem
	 * @param board is the 2D array which contains the arrangement of the queens
	 * @param column is the column of the current queen
	 * @return {boolean}
	 */
	public boolean startNQueensProblem(int[][] board, int column)
	{
		if (dimension == 3 || dimension == 2) {
			throw new AssertionError("N Queens problem cannot be solved for this");
		} else if (board.length < 1) {
			throw new AssertionError("Board size cannot be 0");
		} else {
			if (solveNQueensProblem(board, column) == false) {
				return false;
			} else {
				printBoard(board);
				return true;
			}
		}
	}
}
