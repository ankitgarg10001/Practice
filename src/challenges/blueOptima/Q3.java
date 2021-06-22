package challenges.blueOptima;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 * 
		 */
		// Scanner
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			long P = s.nextInt();
			long result = 0;
			long res = 0;
			long oldNum = 0;
			for (int j = 0; j < N; j++) {
				long num = s.nextInt();
				res += oldNum - num;
				if (res < 0) {
					result += res;
					res = 0;
				}
				oldNum = num;
			}
			if (result < 0)
				System.out.println(result * -1 * P);
			else
				System.out.println(0);
		}

	}

}
