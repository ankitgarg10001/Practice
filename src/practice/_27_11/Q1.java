package practice._27_11;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Camera Purchase
 * Camera Purchase
E-commerce sites keep experimenting to decide which products to display in what order, to increase a
shopper's likelihood of buying. Your goal is to perform one such experiment.
Suppose, there are 5 brands of cameras sold on your website – Nikon, Canon, Sigma, Fujifilm and Sony.
Each of these brands sell different cameras at distinct prices. For simplicity, each brand is represented by
an integer between to . Your website has shopppers each of whom has a list of brands they are
willing to buy from. Based on every user's buying history, you know that they are most likely to buy the
cheapest camera amongst the brands they like. Your task involves finding this cheapest camera
for each shopper.
Given a list of brands and the prices of their cameras, the list of shoppers and their preferences, for each
shopper, determine the cheapest camera. If no such camera exists, print .
Input Format
The first line contains integer denoting the total number of cameras being sold. The second line
contains an array of integers describing the brands of the cameras. The third line contains an array of
integers describing the prices of those particular cameras.
After that, queries describing the shoppers' preferences follow. A single query is described in lines.
1. represents the number of brands the shopper will buy from.
2. space separated integers in ascending order denoting the index of the brands.
3. cheapest camera to display.
Constraints
all are distinct
Output Format
Output exactly lines. In the of them print a single integer denoting the price of the camera lens the
shopper will buy. If no such lens exists, print .
Sample Input 0
31
1 2
1 3 2
311221
2
2131
Sample Output 0
32-
1
Explanation 0
The store has three different cameras which belong to the brands { , , } and their respective prices are
{ , , }.
The first shopper wants to buy a camera which belongs to the brand . There are two different cameras of
brand and their prices are { , }, and the cheapest is of price .
The second shopper wants to buy a camera which belongs to the brands and . There are three
different cameras which belong to those brands, and their prices are { , , }. The cheapest is of
price .
The third shopper wants to buy a camera which belongs to brand , but there are no cameras of brand
being sold. So, print .
 */
public class Q1 {

	public static void main(String[] args) {
		byMe();
		// byBaseCode();

	}

	public static void byBaseCode() {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] brands = new int[n];
		for (int brands_i = 0; brands_i < n; brands_i++) {
			brands[brands_i] = in.nextInt();
		}
		int[] prices = new int[n];
		for (int prices_i = 0; prices_i < n; prices_i++) {
			prices[prices_i] = in.nextInt();
		}
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int d = in.nextInt();
			int[] cameras = new int[d];
			for (int cameras_i = 0; cameras_i < d; cameras_i++) {
				cameras[cameras_i] = in.nextInt();
			}
			int k = in.nextInt();
		}
		in.close();
	}

	private static void byMe() {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] temp = new int[N][2];
		for (int i = 0; i < N; i++) {
			temp[i][0] = s.nextInt();
		}
		for (int i = 0; i < N; i++) {
			temp[i][1] = s.nextInt();
		}
		HashMap<Integer, LinkedList<Integer>> input = new HashMap<>();
		for (int i = 0; i < N; i++) {
			LinkedList<Integer> l = input.get(temp[i][0]);
			if (l == null) {
				l = new LinkedList<>();
				input.put(temp[i][0], l);
			}
			l.add(temp[i][1]);
		}
		temp = null;
		int k = s.nextInt();
		for (int i = 0; i < k; i++) {
			int d = s.nextInt();
			LinkedList<Integer> result = new LinkedList<>();
			for (int j = 0; j < d; j++) {
				int e = s.nextInt();
				LinkedList<Integer> temp1 = input.get(e);
				if (temp1 != null)
					result.addAll(temp1);
			}
			Collections.sort(result);
			int l = s.nextInt();
			System.out.println(l <= result.size() ? result.get(l - 1) : -1);

		}
		s.close();
	}

}
