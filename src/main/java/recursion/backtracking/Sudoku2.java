package recursion.backtracking;


//Faster than 99.6% from Leetcode
public class Sudoku2 {

    public static void main(String[] args) {
        Sudoku2 sudoku = new Sudoku2();
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
        if (sudoku.solveSudoku(currentProblem)) {
            displaySudoku(currentProblem);
        } else
            System.out.println("No Solution Found");
    }

    private static void displaySudoku(char[][] currentProblem) {
        for (char[] ints : currentProblem) {
            for (char anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println("");
        }

    }

    public boolean solveSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] cols = new int[board.length];
        int boxSize= (int) Math.sqrt(board.length);
        int[][] blocks = new int[boxSize][boxSize];

        // stores all existing numbers first
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int number = board[i][j] - '1';
                if (number <= 8 && number >= 0) {
                    number = 1 << number;
                    rows[i] |= number;
                    cols[j] |= number;
                    blocks[i / boxSize][j / boxSize] |= number;
                }
            }
        }

        return dfs(rows, cols, blocks, board, 0, 0);
    }

    private boolean dfs(int[] rows, int[] cols, int[][] blocks, char[][] board, int row, int col) {
        if (col >= board.length) {
            col =0 ;
            row++;
        }

        if (row >= board.length) {
            return true;
        }

        if (board[row][col] != '.') {
            return dfs(rows, cols, blocks, board, row, col + 1);
        }
        int boxSize= (int) Math.sqrt(board.length);
        for (int n = 0; n < board.length; n++) {
            int number = 1 << n;
            if ((rows[row] & number) == 0 && (cols[col] & number) == 0 && (blocks[row / boxSize][col / boxSize] & number) == 0) {
                board[row][col] = (char) ('1' + n);
                rows[row] |= number;
                cols[col] |= number;
                blocks[row / boxSize][col / boxSize] |= number;

                if (dfs(rows, cols, blocks, board, row, col + 1))
                    return true;

                board[row][col] = '.';
                rows[row] ^= number;
                cols[col] ^= number;
                blocks[row / boxSize][col / boxSize] ^= number;

            }
        }
        return false;
    }
}