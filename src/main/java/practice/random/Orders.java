package practice.random;
import java.util.ArrayList;
import java.util.Scanner;

public class Orders {
	public static void main(String[] args) {
		/*
		 * 1 5 3 3 1 2 3 4 5 5 4 3 2 1
		 */
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if (s.hasNextLine())
			s.nextLine();
		for (int i = 0; i < N; i++) {
			int k = s.nextInt();
			int p = s.nextInt();
			int q = s.nextInt();
			if (s.hasNextLine())
				s.nextLine();
			int[] a = new int[k];
			int[] b = new int[k];
			for (int j = 0; j < k; j++) {
				a[j] = s.nextInt();
			}
			if (s.hasNextLine())
				s.nextLine();
			for (int j = 0; j < k; j++) {
				b[j] = s.nextInt();
			}
			System.out.println(solve(k, p, q, a, b, new ArrayList<Integer>()));

			if (s.hasNextLine())
				s.nextLine();
		}
		s.close();
	}

	private static int solve(int k, int p, int q, int[] a, int[] b, ArrayList<Integer> result) {
		int sum = 0;
		while ((p > 0 || q > 0) && k > 0) {
			int pIndex = -1;
			int qIndex = -1;
			if (p > 0) {
				pIndex = getMaxAvailable(a, result);
			}
			if (q > 0) {
				qIndex = getMaxAvailable(b, result);
			}
			if (pIndex == -1 || (pIndex > -1 && qIndex > -1 && a[pIndex] < b[qIndex])) {
				result.add(qIndex);
				sum += b[qIndex];
				System.out.println("adding b :" + b[qIndex]);
				q--;
				k--;
			} else if (qIndex == -1 || (pIndex > -1 && qIndex > -1 && a[pIndex] > b[qIndex])) {
				result.add(pIndex);
				sum += a[pIndex];
				System.out.println("adding a :" + a[pIndex]);
				p--;
				k--;
			} else if ((pIndex > -1 && qIndex > -1 && a[pIndex] == b[qIndex])) {
				result.add(pIndex);
				int tempPindex = getMaxAvailable(a, result);
				result.remove(Integer.valueOf(pIndex));
				result.add(qIndex);
				int tempQindex = getMaxAvailable(b, result);
				result.remove(Integer.valueOf(qIndex));
				if (tempPindex > -1 && tempQindex > -1 && a[tempPindex] > b[tempQindex]) {
					result.add(qIndex);
					sum += b[qIndex];
					System.out.println("adding b :" + b[qIndex]);
					q--;
					k--;
				} else {
					result.add(pIndex);
					sum += a[pIndex];
					System.out.println("adding a :" + a[pIndex]);
					p--;
					k--;
				}

			}
		}
		return sum;

	}

	private static int getMaxAvailable(int[] a, ArrayList<Integer> exclude) {
		int result = -1;
		for (int i = 0; i < a.length; i++) {
			if (!exclude.contains(i)) {
				if (result == -1)
					result = i;
				else if (a[result] < a[i]) {
					result = i;
				}
			}
		}
		return result;
	}
}
