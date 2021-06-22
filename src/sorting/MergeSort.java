package sorting;

public class MergeSort extends Sorts {

    public static void main(String[] args) {
        Integer[] arr = getJumbledArray(10);
        MergeSort ob = new MergeSort();
        System.out.println("Input:");
        ob.printArray(arr);
        ob.sort(arr);
        System.out.println("Sorted array is");
        ob.printArray(arr);
    }

    void sort(Integer[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    void merge(Integer[] arr, int low, int mid, int high) {
        int arr1Size = mid - low + 1;
        int arr2Size = high - mid;
        int[] arr1 = new int[arr1Size];
        int[] arr2 = new int[arr2Size];
        for (int i = 0; i < arr1Size; ++i) {
            arr1[i] = arr[low + i];
        }
        for (int j = 0; j < arr2Size; ++j) {
            arr2[j] = arr[mid + 1 + j];
        }
        int arr1Index = 0, arr2Index = 0;
        int resultIndex = low;
        while (arr1Index < arr1Size && arr2Index < arr2Size) {
            if (arr1[arr1Index] <= arr2[arr2Index]) {
                arr[resultIndex] = arr1[arr1Index];
                arr1Index++;
            } else {
                arr[resultIndex] = arr2[arr2Index];
                arr2Index++;
            }
            resultIndex++;
        }
        while (arr1Index < arr1Size) {
            arr[resultIndex] = arr1[arr1Index];
            arr1Index++;
            resultIndex++;
        }
        while (arr2Index < arr2Size) {
            arr[resultIndex] = arr2[arr2Index];
            arr2Index++;
            resultIndex++;
        }
    }
}