package dynamicProgramming;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "ankit";
        String s2 = "aankit";
        System.out.println(transformRecursive(s1, s2, s1.length(), s2.length()));
        System.out.println(transformDP(s1, s2, s1.length(), s2.length()));
    }

    private static int transformDP(String s1, String s2, int l1, int l2) {
        int[][] a = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) {
                    a[i][j] = j;
                } else if (j == 0) {
                    a[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1];//mathing chars, no work required
                } else {
                    a[i][j] = 1 + min(a[i - 1][j], a[i - 1][j - 1], a[i][j - 1]);
                }
            }
        }
        return a[l1][l2];
    }

    private static int transformRecursive(String s1, String s2, int s1Length, int s2Length) {
        if (s1Length == 0) {
            return s2Length;
        } else if (s2Length == 0) {
            return s1Length;
        }

        if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
            return transformRecursive(s1, s2, s1Length - 1, s2Length - 1);
        } else {
            return min(
                transformRecursive(s1, s2, s1Length - 1, s2Length),//delete
                transformRecursive(s1, s2, s1Length - 1, s2Length - 1),//replace
                transformRecursive(s1, s2, s1Length, s2Length - 1));//insert
        }
    }


    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
