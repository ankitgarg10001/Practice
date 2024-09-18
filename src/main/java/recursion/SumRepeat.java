package recursion;

import java.util.ArrayList;

/**
 * get all possible combinations from array to get sum(Repetition allowed)
 * https://www.geeksforgeeks.org/combinational-sum/
 * 
 * @author Ankit.Garg
 *
 */
public class SumRepeat {
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8 };
		System.out.println(getSum(a, 8, a.length, new ArrayList<Integer>()));
	}

	private static int getSum(int[] a, int sum, int n, ArrayList<Integer> arrayList) {
		if (sum == 0) {
			System.out.println(arrayList);
			return 1;
		}
		if (sum < 0 || n < 1)
			return 0;
		if (a[n - 1] <= sum) {
			arrayList.add(a[n - 1]);
			int auxSum = getSum(a, sum - a[n - 1], n, arrayList);
			arrayList.remove((Integer) a[n - 1]);
			auxSum += getSum(a, sum, n - 1, arrayList);
			return auxSum;
		} else {
			return getSum(a, sum, n - 1, arrayList);
		}

	}
}
