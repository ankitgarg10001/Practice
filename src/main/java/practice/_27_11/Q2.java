package practice._27_11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		String x = in.next();
		String y = in.next();
		int result = minCost(x, y, k);
		System.out.println(result);
		in.close();
	}

	private static int minCost(String x, String y, int k) {
		int lcs = lcs(x.toCharArray(), y.toCharArray());
		if (lcs >= k) {
			return 0;
		}
		return editDistDP(x, y, k - lcs);

	}

	static int lcs(char[] X, char[] Y) {
		int L[][] = new int[X.length + 1][Y.length + 1];
		for (int i = 0; i <= X.length; i++) {
			for (int j = 0; j <= Y.length; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[X.length][Y.length];
	}

	static int editDistDP(String str1, String str2, int minEdits) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		LinkedList<Integer> l = new LinkedList<>();
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0)
					dp[i][j] = j;

				else if (j == 0)
					dp[i][j] = i;

				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
					l.push(dp[i][j]);
				}

				else {
					dp[i][j] = Math.abs(((str1.charAt(i - 1) - 'a') ^ (str2.charAt(j - 1) - 'a')))/* + dp[i - 1][j - 1]*/;
					l.push(dp[i][j]);
				}
			}
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++)
				System.out.print(dp[i][j] + "  ");
			System.out.println("");
		}

		Collections.sort(l);
		int sum = 0;
		for (int i = 0; i < minEdits; i++) {
			sum += l.get(i);
		}
		return sum;
	}
}
