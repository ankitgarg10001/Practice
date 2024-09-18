package string_manipulation;

import java.util.Scanner;

/*MS Excel columns has a pattern like A, B, C, ... ,Z, AA, AB, AC,... ,AZ, BA, BB, ... ZZ, AAA, AAB .... etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.

Given a column number, find its corresponding Excel column name. Following are more examples.

Input          Output
 26             Z
 51             AY
 52             AZ
 80             CB
 676            YZ
 702            ZZ
 705            AAC
 
 */
public class ExcelRowNumber {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			int k = s.nextInt();
			String res = "";
			while (k > 0) {
				int rem = k % 26;
				k = k / 26;
				if (rem == 0) {
					rem += 26;
					k--;
				}
				res = (char) ('A' + rem - 1) + res;

			}
			System.out.println(res);
		}

	}
}
