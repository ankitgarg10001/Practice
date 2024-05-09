package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(search(arr, 0, arr.length - 1, 7));
	}

	private static int search(int[] arr, int low, int high, int result) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == result)
			return mid;
		else {
			if (arr[mid] < result)
				return search(arr, mid, high, result);
			else
				return search(arr, low, mid, result);
		}
	}
}
