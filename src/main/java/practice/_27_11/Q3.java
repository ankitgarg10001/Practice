package practice._27_11;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n];
		Arrays.fill(a, 0);
		while (q > 0) {
			q--;
			int op = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			int val = 0;
			if (op == 1) {
				val = in.nextInt();
				for (int i = l - 1; i < r; i++) {
					a[i] ^= val;
				}
			} else if (op == 3) {
				int start = -1, end = -1;
				for (int i = l - 1; i < r; i++) {
					if (a[i] == 1) {
						if (start == -1)
							start = i;
						else
							end = i;
					}
				}
				if (start >= end)
					System.out.println(-1);
				else
					System.out.println(end - start);
			} else {
				int dist = Integer.MAX_VALUE;
				int start = -1, end = -1;
				for (int i = l - 1; i < r; i++) {
					if (a[i] == 1) {
						if (start == -1)
							start = i;
						else {
							end = i;
							dist = Math.min(dist, end - start);
							start = end;
						}
					}
				}
				System.out.println(dist == Integer.MAX_VALUE ? -1 : dist);
			}
		}
		in.close();

	}

}
