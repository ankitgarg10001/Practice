package algorithms;

/**
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * 
 * Given a sorted array arr[] and a value X, find the k closest elements to X in
 * arr[]. Examples:
 * 
 * Input: K = 4, X = 35 arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55,
 * 56} Output: 30 39 42 45 Note that if the element is present in array, then it
 * should not be in output, only the other closest elements are required.
 * 
 * @author Ankit.Garg
 *
 */
public class FindKNearestElements {
	public static void main(String[] args) {
		int[] a = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int number = 35;
		int count = 4;
		findNumbersInSorted(a, number, count);
	}

	/**
	 * works only if element is present in aray, else udpate binary search to get
	 * element closest to input number
	 * 
	 * @param a
	 * @param number
	 * @param count
	 */
	private static void findNumbersInSorted(int[] a, int number, int count) {
		int index = binarySearch(a, number, 0, a.length - 1);
		if (index == -1) {
			System.out.println("ERR: Invalid Input");
			return;
		}
		int low = index - 1, high = index + 1;
		while (count > 0) {
			if (low >= 0 && high < a.length) {
				if (Math.abs(a[low] - number) < Math.abs(a[high] - number)) {
					System.out.println(a[low--]);
					--count;
				} else {
					System.out.println(a[high++]);
					--count;
				}
			} else if (low < 0 && high < a.length) {
				System.out.println(a[high++]);
				--count;
			} else if (high >= a.length && low >= 0) {
				System.out.println(a[low--]);
				--count;
			} else {
				System.out.println("ERR: no data left to display");
				return;
			}
		}
	}

	private static int binarySearch(int[] a, int number, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (a[mid] == number)
			return mid;
		if (a[mid] > number)
			return binarySearch(a, number, low, mid - 1);
		else
			return binarySearch(a, number, mid + 1, high);
	}
}
