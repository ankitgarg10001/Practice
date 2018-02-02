package challanges.date_9_9;

import java.util.Arrays;
import java.util.Scanner;

public class XorProblem {
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
			int N = s.nextInt();
			int M = s.nextInt();
			int P = s.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = s.nextInt();
			}
			Arrays.sort(arr);
			int minPQ = Math.min(M, P);
			int outI = 0, outJ = 0, outF3 = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + minPQ - 1; j < arr.length; j++) {
					int f1 = xorStart(arr, i, j, M);
					int f2 = xorEnd(arr, i, j, P);
					int f3 = f1 & f2;
					if (f3 > outF3) {
						outI = i;
						outJ = j;
						outF3 = f3;
					} else if (f3 == outF3) {
						if (outJ - outI < j - i) {
							outI = i;
							outJ = j;
						}
					}
				}
			}
			System.out.println((outI + 1) + " " + (outJ + 1) + " " + outF3);
		}
		s.close();

	}

	private static int xorEnd(int[] arr, int i, int j, int p) {
		Integer res = null;
		for (int start = j; start > 0 && start > j - p; start--) {
			if (res == null)
				res = arr[start];
			else
				res = res ^ arr[start];
		}
		return res == null ? 0 : res;
	}

	private static int xorStart(int[] arr, int i, int j, int m) {
		Integer res = null;
		for (int start = i; start < arr.length && start < i + m; start++) {
			if (res == null)
				res = arr[start];
			else
				res = res ^ arr[start];
		}
		return res == null ? 0 : res;
	}
}
