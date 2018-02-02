package challanges.date_6_9;

import java.util.Scanner;

public class Amazon1 {
	int modulo = 1000000007;

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 * 
		 * //Scanner
		 */
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		Amazon1 testClass = new Amazon1();
		System.out.println(testClass.printPoints(arr));
	}

	public int printPoints(int[] arr) {
		// System.out.println("10");
		int count[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[i] = check(i, arr);
			if (count[i] == 0)
				return 0;
		}
		int result = 1;
		for (int i = 0; i < count.length; i++) {
			result = mulmod(result, count[i]);
		}
		return result;

	}

	public int check(int index, int[] arr) {
		int count = 0;
		if (arr[index] == 0) {
			count = 1;
		} else if (arr[index] == 1) {
			count = 2;
		} else {
			int even = 0, odd = 0;
			even = arr[index] / 2 + 1;
			if (arr[index] % 2 == 0) {
				odd = even - 1;
			} else {
				odd = even;
			}
			count = arr[index] + 1;
			count %= modulo;
			count += mulmod(even, even - 1);
			count %= modulo;
			count += mulmod(odd, odd - 1);
			count %= modulo;

		}
		System.out.println(arr[index] + "  :  " + count);
		return count;

	}

	int mulmod(int a, int b) {
		int res = 0;
		a = a % modulo;
		while (b > 0) {
			// If b is odd, add 'a' to result
			if (b % 2 == 1)
				res = (res + a) % modulo;

			// Multiply 'a' with 2
			a = (a * 2) % modulo;

			// Divide b by 2
			b /= 2;
		}

		// Return result
		return res % modulo;
	}
}
