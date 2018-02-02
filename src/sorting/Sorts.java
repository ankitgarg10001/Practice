package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Sorts {
	protected static Integer[] getJumbeledArray(int i) {
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			list.add(j + 1);

		}
		Collections.shuffle(list);
		return list.toArray(new Integer[list.size()]);
		// return list.stream().mapToInt(Integer::intValue).toArray();
	}

	protected void printArray(Integer[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public abstract void sort(Integer[] arr);

}
