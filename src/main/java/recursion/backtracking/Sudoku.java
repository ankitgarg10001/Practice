package recursion.backtracking;

import java.util.ArrayList;
import java.util.Vector;

public class Sudoku {
    final int arrSize = 9;

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] currentProblem = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
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


    private boolean solve(char[][] sudoku, int row, int col) {
        if (row == sudoku.length - 1 && col == sudoku.length) return true;
        if (col == sudoku.length) {
            ++row;
            col = 0;
        }
        if (sudoku[row][col] != '.') return solve(sudoku, row, col + 1);
        for (int k = 1; k <= sudoku.length; k++) {
            if (isSafe(sudoku, row, col, k)) {
                sudoku[row][col] = (char) ('0' + k);
                if (solve(sudoku, row, col + 1)) {
                    return true;
                }
                sudoku[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] sudoku, int row, int col, int expectedValue) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] - '0' == expectedValue || sudoku[i][col] - '0' == expectedValue)
                return false;

        }
        int boxSize = (int) Math.sqrt(sudoku.length);
        int baseColumnValue = (col / boxSize) * boxSize;
        int baseRowValue = (row / boxSize) * boxSize;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (sudoku[baseRowValue + i][baseColumnValue + j] - '0' == expectedValue)
                    return false;
            }
        }
        return true;
    }

    private static void displaySudoku(char[][] currentProblem) {
        for (int i = 0; i < currentProblem.length; i++) {
            for (int j = 0; j < currentProblem[i].length; j++) {
                System.out.print(currentProblem[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
