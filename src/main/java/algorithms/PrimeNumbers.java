package algorithms;

import java.util.Scanner;

public class PrimeNumbers {
	static boolean[] primes = new boolean[1000001];
	static int maxChecked = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		sieveOfEratosthenes(primes.length - 1);
		for (int a0 = 0; a0 < q; a0++) {
			int startVal = in.nextInt();
			int endVal = in.nextInt();
			int result = maxDifference(startVal, endVal);
			System.out.println(result);
		}
		in.close();
	}

	/**
	 * difference betwen start n end range's extreme prime numbers
	 * @param startVal
	 * @param endVal
	 * @return
	 */
	private static int maxDifference(int startVal, int endVal) {
		int start = 0;
		int end = 0;
		for (int i = startVal; i <= endVal; i++) {
			if (primes[i]) {
				start = i;
				break;
			}
		}
		for (int i = endVal; i >= startVal; i--) {
			if (primes[i]) {
				end = i;
				break;
			}
		}

		return end - start;
	}

	/**
	 * all numbers are factors of prime numbers, mark all multiples as false
	 * @param n
	 */
	static void sieveOfEratosthenes(int n) {
		for (int i = 0; i <= n; i++)
			primes[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (primes[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					primes[i] = false;
			}
		}
	}
}
