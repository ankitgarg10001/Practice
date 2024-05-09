package algorithms;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int gcd = GCD(B, A);
		System.out.println(gcd);
		System.out.println(B * A / gcd);
		s.close();
	}

	private static int GCD(int max, int min) {
		if (min == 0)
			return max;
		return GCD(min, max % min);
	}

}
