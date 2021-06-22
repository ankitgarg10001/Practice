package challenges.Amazon.Feb_2018;

import java.util.Scanner;

public class PartitionSum {
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
			int X = s.nextInt();
			int K = s.nextInt();
			table = new int[X + 1][K + 1];
			System.out.println(waysToSum(X, K));
		}
		s.close();
	}

	static int[][] table;
	static int modulo = 1000000007;

	private static int waysToSum(int N, int K) {

		if (K == 0)
			return 0;
		if (N == 0)
			return 1;
		if (N < 0)
			return 0;

		if (table[N][K] != 0)
			return table[N][K];

		table[N][K] = (int) ((long) waysToSum(N, K - 1) + (long) waysToSum(N - K, K)) % modulo;
		return table[N][K];
	}

	//	public static void main(String[] args) throws IOException {
	//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//		PrintWriter wr = new PrintWriter(System.out);
	//		int T = Integer.parseInt(br.readLine().trim());
	//		for (int t_i = 0; t_i < T; t_i++) {
	//			String[] in = br.readLine().split(" ");
	//			long N = Long.parseLong(in[0]);
	//			long K = Long.parseLong(in[1]);
	//
	//			long out_ = solve(K, N);
	//			System.out.println(out_);
	//			System.out.println("");
	//		}
	//
	//		wr.close();
	//		br.close();
	//	}
	//
	//	static long solve(long K, long N) {
	//		ways=0;
	//		waysToSum(N, K, 0);
	//		return ways;
	//	}
	//
	//	static int modulo = 1000000007;
	//	static int ways;
	//
	//	private static void waysToSum(long n, long k, int currentSum) {
	//		if (currentSum > n)
	//			return;
	//		if (currentSum == n) {
	//			ways += 1;
	//			ways %= modulo;
	//			return;
	//		}
	//		for (intx i = 1; i <= k; i++) {
	//			waysToSum(n, k, currentSum + i);
	//		}
	//		return;
	//	}

}
