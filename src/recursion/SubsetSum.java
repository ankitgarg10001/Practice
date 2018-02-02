package recursion;

public class SubsetSum {
	Integer[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int sumValueNeeded = 15;

	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		subsetSum.getAllCombinatins();

	}

	private void getAllCombinatins() {
		for (int i = 0; i < inputArray.length; i++) {
			if (getSum(inputArray, sumValueNeeded, i, inputArray[i]))
				System.out.println("\n------------------");
		}

	}

	private boolean getSum(Integer[] inputArray, int sumValueNeeded, int currentIndex, int currentSum) {
		if (currentSum == sumValueNeeded) {
			System.out.print(inputArray[currentIndex] + "\t");
			return true;
		}
		for (int j = currentIndex + 1; j < inputArray.length; j++) {
			if (getSum(inputArray, sumValueNeeded, j, currentSum + inputArray[j])) {
				System.out.print(inputArray[currentIndex] + "\t");
				return true;
			}

		}
		return false;
	}

}
