package practice.random;

public class q3 {

	private static String[] output1;

	public static void main(String[] args) {
		String a = "hi my name is ankit";
		int input1 = 2;
		int input2[] = { 101, 12 };
		checkpalendrome(input1, input2);
		// System.out.println(reverseString(a));

	}

	private static void checkpalendrome(int input1, int[] input2) {
		output1 = new String[input1];
		generateOutput(input1, input2);
	}

	private static void generateOutput(int input1, int[] input2) {
		for (int i = 0; i < input1; i++) {
			int k = reverseNum(input2[i]);
			if (k == input2[i]) {
				output1[i] = "PALINDROME";
			} else {
				output1[i] = "NOT";
			}
			// System.out.println(output1[i]);
		}
		// System.out.println(output1);
	}

	private static int reverseNum(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10;
			rev = rev + n % 10;
			n = n / 10;
		}
		return rev;
	}

	private static String reverseString(String str) {

		int strLeng = str.length() - 1;
		String reverse = "", temp = "";

		for (int i = 0; i <= strLeng; i++) {

			if (str.charAt(i) != ' ') {
				temp += str.charAt(i);
			}

			if ((str.charAt(i) == ' ') || (i == strLeng)) {
				boolean caps = true;
				for (int j = temp.length() - 1; j >= 0; j--) {
					if (caps) {
						reverse += Character.toUpperCase(temp.charAt(j));
						caps = false;
					} else {
						reverse += temp.charAt(j);
					}
					// if ((j == 0) && (i != strLeng))
					// reverse += " ";

				}
				if (str.charAt(i) == ' ') {
					reverse += " ";
				}
				temp = "";
			}
		}
		return reverse;
	}

}
