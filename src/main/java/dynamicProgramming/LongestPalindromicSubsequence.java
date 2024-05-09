package dynamicProgramming;

public class LongestPalindromicSubsequence {

    // A utility function to get max of two integers
    static int max(int x, int y) {
        return Math.max(x, y);
    }
    // Returns the length of the longest palindromic subsequence in seq

    static int lpsRecursive(char[] seq, int i, int j) {
        // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }

        // If the first and last characters match
        if (seq[i] == seq[j]) {
            return lpsRecursive(seq, i + 1, j - 1) + 2;
        }

        // If the first and last characters do not match
        return max(lpsRecursive(seq, i, j - 1), lpsRecursive(seq, i + 1, j));
    }


    /* Driver program to test above function */
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";//eg. EESEE
        int n = seq.length();
        System.out.println("The length of the LPS is " + lpsRecursive(seq.toCharArray(), 0, n - 1));
        System.out.println("The length of the LPS is " + lpsDp(seq, n));

    }

    private static int lpsDp(String seq, int n) {
        int[][] L = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            L[i][i] = 1;
//        }
        for (int cl = 1; cl <= n; cl++) {//current Length
            for (int i = 0; i < n - cl + 1; i++) {//string starting index
                int j = i + cl - 1;
                if (i == j) {
                    L[i][j] = 1;
                } else if (seq.charAt(i) == seq.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                } else if (seq.charAt(i) == seq.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = max(L[i][j - 1], L[i + 1][j]);
                }
            }
        }
        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L[i].length; j++) {
                System.out.print(L[i][j] + "  ");
            }
            System.out.println();
        }
        return L[0][n - 1];
    }
}
