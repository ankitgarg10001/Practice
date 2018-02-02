package sorting;

public class InsertionSort extends Sorts {
	public static void main(String args[]) {
		Integer arr[] = getJumbeledArray(10);
		InsertionSort ob = new InsertionSort();
		System.out.println("Input:");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array is");
		ob.printArray(arr);
	}


	@Override
	public void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}