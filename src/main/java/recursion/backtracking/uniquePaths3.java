package recursion.backtracking;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class uniquePaths3 {

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 2, -1}
//        };
//        int[][] grid = {{0, 1}, {2, 0}};
        int[][]grid={{0,0,0,0,0,0,2,0,0,0},{0,0,0,0,0,0,0,0,1,0}};
        int result = getResult(grid);
        System.out.println(result);
    }

    private static int getResult(int[][] grid) {
        int count = 0;
        int row = -1;
        int column = -1;
        for (int i = 0, gridLength = grid.length; i < gridLength; i++) {
            for (int j = 0, intsLength = grid[i].length; j < intsLength; j++) {
                int anInt = grid[i][j];
                if (anInt == 0) count++;
                if (anInt == 1) {
                    row = i;
                    column = j;
                }
            }

        }
        int result = getResult(grid, row, column, count);
        return result;
    }

    private static int findPaths(int[][] grid, int row, int column, int zeroesLeft) {
        if (row < 0 || row == grid.length || column < 0 || column == grid[row].length) return 0;
        if (grid[row][column] == 2) {
            if (zeroesLeft == 0)
                return 1;
            else return 0;
        }
        if (grid[row][column] !=0) {
            return 0;
        }
        if (grid[row][column] == 0) {
            grid[row][column] = 3;
            --zeroesLeft;
        }
        int result = getResult(grid, row, column, zeroesLeft);

        if (grid[row][column] == 3) {
            grid[row][column] = 0;
            ++zeroesLeft;
        }
        return result;
    }

    private static int getResult(int[][] grid, int row, int column, int zeroesLeft) {
        int result = 0;
        result += findPaths(grid, row + 1, column, zeroesLeft);
        result += findPaths(grid, row, column + 1, zeroesLeft);
        result += findPaths(grid, row - 1, column, zeroesLeft);
        result += findPaths(grid, row, column - 1, zeroesLeft);
        return result;
    }

}
