package practice.random;

public class fabonacci {

	public static void main(String[] args) {
		double input1 = 0;
		// String input2="{1,7,5,2},{5,12,3,6},{100,9,23,16},{16,4,5,9}";
		double input2 = 100000000;
		System.out
				.println((sumFabonacci(input2) - sumFabonacci(input1 - 1)) % 1000000007);

	}

	private static double sumFabonacci(double k) {
		return getFabonacci(k + 2) - 1;
	}

	public static double getFabonacci(double n) {
		if (n < 1)
			return 0;
		else if (n == 1)
			return 1;
		else
			return getFabonacci(n - 1) + getFabonacci(n - 2);

	}

}
