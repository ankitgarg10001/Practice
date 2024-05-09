package challenges.Misc;

import java.util.Scanner;

public class ConnectedCells {
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
		boolean arr[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = s.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j) == '*';
			}
		}
		int output = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j]) {
					output += check(arr, i, j, new boolean[N][N]);
				}
			}
		}
		System.out.println(output);
		s.close();
	}

	private static int check(boolean[][] arr, int i, int j, boolean[][] addedPoints) {
		int res = 1;
		addedPoints[i][j] = true;
		if (i - 1 >= 0 && !addedPoints[i - 1][j] && !arr[i - 1][j]) {
			res += check(arr, i - 1, j, addedPoints);
		}
		if (j - 1 >= 0 && !addedPoints[i][j - 1] && !arr[i][j - 1]) {
			res += check(arr, i, j - 1, addedPoints);
		}
		if (i + 1 < arr.length && !addedPoints[i + 1][j] && !arr[i + 1][j]) {
			res += check(arr, i + 1, j, addedPoints);
		}
		if (j + 1 < arr.length && !addedPoints[i][j + 1] && !arr[i][j + 1]) {
			res += check(arr, i, j + 1, addedPoints);
		}
		return res;
	}
}
