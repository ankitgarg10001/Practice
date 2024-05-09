package recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class sumIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting
     * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water. Example 1:
     *
     * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"], ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 Example 2:
     *
     * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"], ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
     */
    public static void main(String[] args) {
//        char[][] grid = {
//            {'1', '1', '0', '0', '0'},
//            {'1', '1', '0', '0', '0'},
//            {'0', '0', '1', '0', '0'},
//            {'0', '0', '0', '1', '1'}
//
//        };
        System.out.println(numIslands(new char[][]{
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsUtil(grid, i, j);
                    ++count;
                    // System.out.println("Found Island " + count);
                }
            }
        }
        return count;
    }

    private static void numIslandsUtil(char[][] grid, int i, int j) {
        if (i == grid.length || i < 0 || j == grid[i].length || j < 0 || grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
        }
        numIslandsUtil(grid, i, j + 1);
        numIslandsUtil(grid, i, j - 1);
        numIslandsUtil(grid, i + 1, j);
        numIslandsUtil(grid, i - 1, j);
    }
}
