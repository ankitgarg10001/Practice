package challenges.Misc;

import java.util.Scanner;

public class SpecialPoints {
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
		int T = s.nextInt();

		while (T-- > 0) {
			int X = s.nextInt();
			int Y = s.nextInt();
			int Z = s.nextInt();
			int A = s.nextInt();
			int B = s.nextInt();
			int res = Math.max(Y + A, Z + B);
			int outputNumber = res - X + 1;
			if (outputNumber <= X)
				System.out.println(outputNumber);
			else
				System.out.println(0);
		}
		s.close();
	}

}
