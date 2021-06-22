package challenges.salseforce.May26_2021;


import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "ANKIT";
        String s2 = "NKITA";
        int length = findLcs(s1, s2);
        System.out.println(length);
    }

    private static int findLcs(String s1, String s2) {
        int[][] result = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : result) {
            Arrays.fill(arr, 0);
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                result[i][j] = Math.max(Math.max(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    result[i][j] += 1;
                }
            }
        }
        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }

        return result[s1.length()][s2.length()];
    }
}
