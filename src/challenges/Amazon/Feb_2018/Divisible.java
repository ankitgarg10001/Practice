package challenges.Amazon.Feb_2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisible {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 * Use either of these methods for input
		
		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		*/

		//Scanner
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int index = s.nextInt();
			System.out.println(getDivisionNumber(a, b, index));
		}
		s.close();
	}

	private static long getDivisionNumber(long a, long b, long n) {
		long lcm = lcm(a, b);
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= lcm; i++) {
			if (i % a == 0 || i % b == 0) {
				arr.add(i);
			}
		}
		long mul = n / arr.size();
		return mul * lcm + (arr.get((int) ((n % arr.size()) - 1)));

	}

	private static long gcd(long a, long b) {
		if (a == b)
			return a;
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}

	private static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

}
