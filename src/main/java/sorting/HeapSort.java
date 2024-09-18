package sorting;

public class HeapSort extends Sorts {
	public static void main(String args[]) {
		Integer arr[] = getJumbledArray(10);
		HeapSort ob = new HeapSort();
		System.out.println("Input:");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array is");
		ob.printArray(arr);
	}

	@Override
	public void sort(Integer[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			heapify(arr, arr.length - 1, i);
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	void heapify(Integer[] arr, int size, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		if (l < size && arr[l] > arr[largest])
			largest = l;
		if (r < size && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, size, largest);
		}
	}

}