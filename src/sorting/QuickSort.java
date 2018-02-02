package sorting;

public class QuickSort extends Sorts {

	public static void main(String args[]) {
		Integer arr[] = getJumbeledArray(10);

		QuickSort ob = new QuickSort();
		System.out.println("Input:");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array is");
		ob.printArray(arr);
	}

	@Override
	public void sort(Integer[] arr) {
		sort(arr, 0, arr.length - 1);

	}

	void sort(Integer[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	int partition(Integer[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				++i;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[++i];
		arr[i] = arr[high];
		arr[high] = temp;

		return i;
	}

}