package challenges.microsoft.sep2021;

public class TicTacBoard {

    public static final int[][] EMPTY_BOARD = {
        {-1, -1, -1},
        {-1, -1, -1},
        {-1, -1, -1}
    };

    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 0},
            {1, 0, 1},
            {1, 1, 0}
        };
        final TicTacBoard ticTacBoard = new TicTacBoard();
        System.out.println(ticTacBoard.isValid(arr));
        System.out.println(ticTacBoard.checkWinner(arr));
        ticTacBoard.printStates(EMPTY_BOARD.clone(), 0, 0, 0);
    }

    private int printStates(int[][] arr, int row, int column, int currCount) {
        if (row >= arr.length || column >= arr.length) {
            return currCount;
        }
        if (!isValid(arr)) {
            return currCount;
        }
        printBoard(arr, ++currCount);
        int newRow = row;
        int newCol = column;
        if (column >= arr.length - 1) {
            newCol = 0;
            newRow++;
        } else {
            newCol++;
        }
        arr[row][column] = 0;
        currCount = printStates(arr, newRow, newCol, currCount);
        arr[row][column] = 1;
        currCount = printStates(arr, newRow, newCol, currCount);
        arr[row][column] = -1;
        return currCount;
    }

    private void printBoard(int[][] arr, int currCount) {
        System.out.println("---Printing State------" + currCount);
        for (int[] row : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();

        }
    }

    private boolean isValid(int[][] arr) {
        int diff = 0;
        for (int[] row : arr) {
            for (int value : row) {
                if (value == 0) {
                    diff++;
                } else if (value == 1) {
                    diff--;
                }
            }
        }
        return Math.abs(diff) <= 1;
    }

    private int checkWinner(int[][] arr) {
        int winner = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                //for row
                if (winner != -1 && winner != arr[i][0]) {
                    throw new RuntimeException("found 2nd winner");
                }
                winner = arr[i][0];
            } else if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                //for column
                if (winner != -1 && winner != arr[0][i]) {
                    throw new RuntimeException("found 2nd winner");
                }
                winner = arr[0][i];
            }
        }
        int leftDiagonalValue = arr[0][0];
        int rightDiagonalValue = arr[0][arr.length - 1];
        boolean leftDiagonalMatch = true;
        boolean rightDiagonalMatch = true;
        for (int i = 1; i < arr.length; i++) {
            if (leftDiagonalValue != arr[i][i]) {
                leftDiagonalMatch = false;
            }
            if (rightDiagonalValue != arr[i][arr.length - 1 - i]) {
                rightDiagonalMatch = false;
            }
        }
        if (leftDiagonalMatch) {
            if (winner != -1 && winner != leftDiagonalValue) {
                throw new RuntimeException("found 2nd winner");
            }
            winner = leftDiagonalValue;
        } else if (rightDiagonalMatch) {
            if (winner != -1 && winner != rightDiagonalValue) {
                throw new RuntimeException("found 2nd winner");
            }
            winner = rightDiagonalValue;
        }
        return winner;
    }

    /*private static int checkWinner(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                //for row
                return arr[i][0];
            } else if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                //for column
                return arr[0][i];
            }
        }
        int leftDiagonalValue = arr[0][0];
        int rightDiagonalValue = arr[0][arr.length - 1];
        boolean leftDiagonalMatch = true;
        boolean rightDiagonalMatch = true;
        for (int i = 1; i < arr.length; i++) {
            if (leftDiagonalValue != arr[i][i]) {
                leftDiagonalMatch = false;
            }
            if (rightDiagonalValue != arr[i][arr.length - 1 - i]) {
                rightDiagonalMatch = false;
            }
        }
        if (leftDiagonalMatch) {
            return leftDiagonalValue;
        } else if (rightDiagonalMatch) {
            return rightDiagonalValue;
        }
        return -1;
    }*/
}
