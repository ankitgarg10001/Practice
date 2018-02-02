package recursion;

import java.util.ArrayList;

public class SubsetSum2 {

	public static void main(String[] args) {

		Integer[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sumValueNeeded = 15;
		SubsetSum2 subsetSum = new SubsetSum2();
		subsetSum.getAllCombinatins(inputArray, sumValueNeeded, new ArrayList<Integer>(), 0);

	}

	private void getAllCombinatins(Integer[] inputArray, int sumValueNeeded, ArrayList<Integer> values,
			int currentIndex) {
		if (0 == sumValueNeeded) {
			System.out.println(values);
			return;
		} else if (0 > sumValueNeeded)
			return;
		else if (currentIndex == inputArray.length)
			return;
		else {
			ArrayList<Integer> res1 = new ArrayList<>(values);
			res1.add(inputArray[currentIndex]);
			ArrayList<Integer> res2 = new ArrayList<>(values);
			getAllCombinatins(inputArray, sumValueNeeded - inputArray[currentIndex], res1, currentIndex + 1);
			getAllCombinatins(inputArray, sumValueNeeded, res2, currentIndex + 1);
		}
	}

}
