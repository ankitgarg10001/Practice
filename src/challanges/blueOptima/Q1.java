package challanges.blueOptima;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = 10;
		while (--k >= 0) {
			int X = s.nextInt();
			long date1 = new GregorianCalendar().getTimeInMillis();
			System.out.println(outputDP(X));
			long date2 = new GregorianCalendar().getTimeInMillis();
			System.out.println(output(X));
			long date3 = new GregorianCalendar().getTimeInMillis();

			System.out.println("Time DP: " + (date2 - date1));
			System.out.println("Time normal: " + (date3 - date2));

		}

	}

	static Long[] arr = new Long[100];

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

	private static long output(int x) {
		if (x == 0)
			return 0l;
		else {
			return Math.max((output(x - 1) + 1) / 2 + (output(x - 1) + 1) / 3 + (output(x - 1) + 1) / 4, x);
		}
	}

}
