package challanges.makeMyTrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */

class TestClass {
	static Integer[][] horses;
	static Integer M, N, Q;

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int C = Integer.parseInt(line);

		for (int i = 0; i < C; i++) {
			line = br.readLine();
			String[] s = line.split(" ");
			M = new Integer(s[0]);
			N = new Integer(s[1]);
			Q = new Integer(s[2]);
			horses = new Integer[Q][2];
			for (int j = 0; j < Q; j++) {
				line = br.readLine();
				String[] k = line.split(" ");
				horses[j][0] = new Integer(k[0]);
				horses[j][1] = new Integer(k[1]);
			}
			System.out.println(CountMoves(0));
		}
	}

	private static int CountMoves(int count) {
		for (int i = 0; i < Q; i++) {
			int temp1 = horses[i][0];
			int temp2 = horses[i][1];
			for (int j = i + 1; j < Q; j++) {
				count += chk(temp1, temp2, j);
			}

		}
		return count * 2;
	}

	private static int chk(int a, int b, int i) {

		int temp1 = horses[i][0];
		int temp2 = horses[i][1];
		if (temp1 - 2 == a && temp2 - 1 == b)
			return 1;
		else if (temp1 - 1 == a && temp2 - 2 == b)
			return 1;
		else if (temp1 - 1 == b && temp2 - 2 == a)
			return 1;
		else if (temp1 - 2 == b && temp2 - 1 == a)
			return 1;
		else if (temp1 + 2 == a && temp2 + 1 == b)
			return 1;
		else if (temp1 + 1 == a && temp2 + 2 == b)
			return 1;
		else if (temp1 + 1 == b && temp2 + 2 == a)
			return 1;
		else if (temp1 + 2 == b && temp2 + 1 == a)
			return 1;
		else if (temp1 - 1 == a && temp2 + 2 == b)
			return 1;
		else if (temp1 - 1 == b && temp2 + 2 == a)
			return 1;
		else if (temp1 - 2 == b && temp2 + 1 == a)
			return 1;
		else if (temp1 + 2 == a && temp2 - 1 == b)
			return 1;
		else if (temp1 + 1 == a && temp2 - 2 == b)
			return 1;
		else if (temp1 + 1 == b && temp2 - 2 == a)
			return 1;
		else if (temp1 + 2 == b && temp2 - 1 == a)
			return 1;
		return 0;
	}
}
