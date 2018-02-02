package challanges.blueOptima;

import java.util.Scanner;

public class Q2 {
	public static void main (String[] args) throws java.lang.Exception
	{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = 10;
		while (--k >= 0) {
			int X = s.nextInt();
			System.out.println(outputDP(X));

		}
	}

	public static Long[] arr = new Long[1000];

	private static long outputDP(int x) {
		if (arr[x] == null) {
			if (x == 0) {
				arr[x] = 0l;
				return arr[x];
			} else {
				arr[x] = Math.max((outputDP(x - 1) + 1) / 2 + (outputDP(x - 1) + 1) / 3 + (outputDP(x - 1) + 1) / 4, x);
				return arr[x];
			}
		}
		return arr[x];
	}
	}
