package sorting;

public class CountingSort extends Sorts {
	public static void main(String args[]) {
		Integer arr[] = { 1, 2, 3, 4, 5, 1, 2, 3, 5, 6, 7, 2, 2, 4 };
		CountingSort ob = new CountingSort();
		System.out.println("Input:");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array is");
		ob.printArray(arr);
	}

	@Override
	public void sort(Integer arr[]) {
		int n = arr.length;
		Integer output[] = new Integer[n];
		int count[] = new int[256];
		for (int i = 0; i < 256; ++i)
			count[i] = 0;
		for (int i = 0; i < n; ++i)
			++count[arr[i]];
		for (int i = 1; i <= 255; ++i)
			count[i] += count[i - 1];
		for (int i = 0; i < n; ++i) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}
}