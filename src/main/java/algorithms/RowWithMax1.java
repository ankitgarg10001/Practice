package algorithms;

public class RowWithMax1 {
	private static int resultRow;

	public static void main(String[] args) {
		int[][] input = { { 0, 0, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(input[0].length - findRow(input, 0, 0));
		System.out.println("Result Row: " + resultRow);
	}

	private static int findRow(int[][] input, int currentRow, int currentMax) {
		if (currentMax == input[0].length - 1)
			return currentMax;
		if (currentRow == input.length - 1)
			return currentMax;
		int pos1 = 0;
		if (input[currentRow][input.length - currentMax - 1] == 0)
			pos1 = currentMax;
		else
			pos1 = findFirst1(input[currentRow], 0, input.length - currentMax);
		int newMax = currentMax != 0 ? Math.min(pos1, currentMax) : pos1;
		if (newMax != currentMax)
			resultRow = currentRow;
		return findRow(input, currentRow + 1, newMax);

	}

	private static int findFirst1(int[] input, int i, int j) {
		int mid = i + ((j - i) / 2);
		if (mid < 0 || mid >= input.length)
			return -1;
		if (input[mid] == 1 && mid - 1 >= 0 && input[mid - 1] == 0)
			return mid;
		else if (input[mid] == 0)
			return findFirst1(input, mid, j);
		else if (input[mid] == 1)
			return findFirst1(input, i, mid);
		return -1;
	}
}
