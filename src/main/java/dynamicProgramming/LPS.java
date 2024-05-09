package dynamicProgramming;

import java.util.Arrays;

public class LPS {

    public static int[][] arr;

    // A utility function to get max of two integers
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    // Returns the length of the longest palindromic subsequence in seq

    static int lps(char seq[], int i, int j) {
        // Base Case 1: If there is only 1 character
        if (arr[i][j] != -1) {
            return arr[i][j];
        }
        if (i == j) {
            arr[i][j] = 1;
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            arr[i][j] = 2;
            return 2;
        }

        // If the first and last characters match
        if (seq[i] == seq[j]) {
            arr[i][j] = lps(seq, i + 1, j - 1) + 2;
            return arr[i][j];
        }
        System.out.printf("Counting for i: %d, j: %d%n", i, j);
        arr[i][j] = max(lps(seq, i, j - 1), lps(seq, i + 1, j));
        // If the first and last characters do not match
        return arr[i][j];
    }


    /* Driver program to test above function */
    public static void main(String[] args) {
        String seq = "GEEKS FOR GEEKS";
        int n = seq.length();
        arr = new int[n + 1][n + 1];
        for (int currArr[] : arr) {
            Arrays.fill(currArr, -1);
        }
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1));

    }

}
