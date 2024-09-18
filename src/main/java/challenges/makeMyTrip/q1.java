package challenges.makeMyTrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */

class q1 {
	static BigInteger one = new BigInteger("1");

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		ArrayList<BigInteger> prisoners = new ArrayList<BigInteger>();
		for (int i = 0; i < N; i++) {
			prisoners = new ArrayList<BigInteger>();
			line = br.readLine();
			String[] s = line.split(" ");
			for (int x = 0; x < s.length; x++) {
				prisoners.add(x, new BigInteger(s[x]));
			}
			System.out.println(CountMoves(prisoners, 0));
		}
	}

	private static Integer CountMoves(ArrayList<BigInteger> prisoners,
			Integer moves) {
		Collections.sort(prisoners);
		if (prisoners.get(0).add(one).compareTo(prisoners.get(1)) == 0
				&& prisoners.get(1).add(one).compareTo(prisoners.get(2)) == 0) {
			return moves;
		}
		Integer left = CountFromLeft(new ArrayList<BigInteger>(prisoners),
				moves);
		Integer right = CountFromRight(new ArrayList<BigInteger>(prisoners),
				moves);
		return left > right ? left : right;

	}

	private static Integer CountFromRight(ArrayList<BigInteger> prisoners,
			Integer moves) {
		Collections.sort(prisoners);
		if (prisoners.get(0).add(one).compareTo(prisoners.get(0)) != 0
				&& prisoners.get(0).add(one).compareTo(prisoners.get(1)) != 0) {
			prisoners.set(2, prisoners.get(0).add(one));
			moves++;
			return CountMoves(new ArrayList<BigInteger>(prisoners), moves);
		} else {
			return moves;
		}
	}

	private static Integer CountFromLeft(ArrayList<BigInteger> prisoners,
			Integer moves) {
		Collections.sort(prisoners);
		if (prisoners.get(2).add(one.negate()).compareTo(prisoners.get(2)) != 0
				&& prisoners.get(2).add(one.negate())
						.compareTo(prisoners.get(1)) != 0) {
			prisoners.set(0, prisoners.get(2).add(one.negate()));
			moves++;
			return CountMoves(new ArrayList<BigInteger>(prisoners), moves);
		} else {
			return moves;
		}
	}
}
