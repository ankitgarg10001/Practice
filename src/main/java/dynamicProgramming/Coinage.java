package dynamicProgramming;

import java.util.Arrays;

public class Coinage {
	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		int V = 11;
		int min[] = new int[V + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.sort(coins);
		System.out.println("Minimum coins required is " + minCoins(coins, min, V));
	}

	private static int minCoins(int[] coins, int[] min, int V) {
		int table[] = new int[V + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
			table[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++) {
			// Go through all coins smaller than i
			for (int j = 0; j < coins.length; j++)
				if (coins[j] <= i) {
					int sub_res = table[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
						table[i] = sub_res + 1;
				}
		}
		return table[V];
	}

	private static int minCoinsMine(int[] coins, int[] min, int count) {
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= count; j++) {
				int newNum = (j / coins[i]);
				if (j % coins[i] != 0) {
					int optimizedSubResult = min[j % coins[i]];
					if (optimizedSubResult == Integer.MAX_VALUE)
						continue;
					newNum += optimizedSubResult;
				}
				if (newNum < min[j]) {
					min[j] = Math.min(newNum, min[j]);
				}
			}
		}
		return min[min.length - 1];
	}

}
