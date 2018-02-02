package recursion.backtracking;

import java.util.ArrayList;
import java.util.Vector;

public class Sudoku {
	final int arrSize = 9;

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		int currentProblem[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		if (sudoku.solve(currentProblem, 0, 0)) {
			for (int i = 0; i < currentProblem.length; i++) {
				for (int j = 0; j < currentProblem[i].length; j++) {
					System.out.print(currentProblem[i][j] + " ");
				}
				System.out.println("");
			}
		} else
			System.out.println("No RepeatingElementsArray");
	}

	private boolean solve(int[][] currentProblem, int row, int col) {
		if (row == arrSize) {
			return true;
		}
		int tempRow = row;
		int tempCol = col;
		if (col + 1 > arrSize - 1) {
			tempCol = 0;
			++tempRow;
		} else {
			++tempCol;
		}
		if (currentProblem[row][col] == 0) {
			for (int i = 0; i < arrSize; i++) {
				currentProblem[row][col] = i + 1;
				if (isSafe(currentProblem, row, col)) {
					if (!solve(currentProblem, tempRow, tempCol))
						currentProblem[row][col] = 0;
					else
						return true;
				} else
					currentProblem[row][col] = 0;

			}
		} else {
			return solve(currentProblem, tempRow, tempCol);
		}
		return false;

	}

	private boolean isSafe(int[][] currentProblem, int row, int col) {
		ArrayList<Integer> rowArr = getNumbersArray(arrSize);
		ArrayList<Integer> colArr = getNumbersArray(arrSize);
		for (int j = 0; j < arrSize; j++) {
			if (currentProblem[row][j] != 0) {
				if (rowArr.contains(currentProblem[row][j]))
					rowArr.remove((Integer) currentProblem[row][j]);
				else
					return false;
			}
			if (currentProblem[j][col] != 0) {
				if (colArr.contains(currentProblem[j][col]))
					colArr.remove((Integer) currentProblem[j][col]);
				else
					return false;
			}
		}

		ArrayList<Integer> box = getNumbersArray(arrSize);
		int baseRow = row / 3;
		int baseCol = col / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (currentProblem[baseRow * 3 + i][baseCol * 3 + j] != 0) {
					if (box.contains(currentProblem[baseRow * 3 + i][baseCol * 3 + j]))
						box.remove((Integer) currentProblem[baseRow * 3 + i][baseCol * 3 + j]);
					else
						return false;
				}
			}

		}
		return true;
	}

	private ArrayList<Integer> getNumbersArray(int arrSize2) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < arrSize2; i++) {
			numbers.add(i + 1);
		}
		return numbers;
	}
}
