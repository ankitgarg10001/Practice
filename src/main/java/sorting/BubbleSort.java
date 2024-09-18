package sorting;

public class BubbleSort extends Sorts {
	public static void main(String args[]) {
		Integer arr[] = getJumbledArray(10);
		BubbleSort ob = new BubbleSort();
		System.out.println("Input:");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array is");
		ob.printArray(arr);
	}

	private void swap(int loopLow, int loopHigh, Integer[] arr) {
		int temp = arr[loopLow];
		arr[loopLow] = arr[loopHigh];
		arr[loopHigh] = temp;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	@Override
	public void sort(Integer[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1, arr);
				}

			}
		}

	}
}