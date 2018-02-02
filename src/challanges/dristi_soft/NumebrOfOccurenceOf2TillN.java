package challanges.dristi_soft;

public class NumebrOfOccurenceOf2TillN {
	public static void main(String[] args) {
		count1(61523);//34507
	}

	private static void count1(int i) {
		int aux = i;
		int index = 0;
		int sum = 0;
		while (aux > 0) {
			aux = aux / 10;
			sum += countInRangeForIndex(i, index);
			index++;
		}
		System.out.println(sum);
	}

	private static int countInRangeForIndex(int number, int d) {

		int powerOf10 = (int) Math.pow(10, d);
		int nextPowerOf10 = powerOf10 * 10;
		int right = number % powerOf10;

		int roundDown = number - number % nextPowerOf10;
		int roundup = roundDown + nextPowerOf10;

		int digit = (number / powerOf10) % 10;

		// if the digit in spot digit is
		if (digit < 2)
			return roundDown / 10;

		if (digit == 2)
			return roundDown / 10 + right + 1;

		return roundup / 10;
	}

	private static void count(int i) {
		int current = 0;
		int sum = 0;
		int lastDigit = 0;
		while (i > 0) {
			int x = i % 10;
			if (current > 0)
				sum += (Math.pow(10, current - 1)) * x;
			if (x >= 2) {
				if (x > 2)
					sum += Math.pow(10, current);
				else {
					sum += lastDigit * (Math.pow(10, current - 1));
				}
			}
			i = i / 10;
			lastDigit = x;
			current++;
		}
		System.out.println(sum);

	}

}
