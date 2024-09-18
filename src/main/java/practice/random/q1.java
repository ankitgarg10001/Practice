package practice.random;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 54;
		String B = "24";
		gcd(A, B);

	}

	static int output1;

	private static void gcd(int A, String B) {
		int m;
		if (A == 1) {
			output1 = 1;
			return;
		}
		m = mod(B, A);
		output1 = aux_gcd(A, m);
		System.out.println(output1);
	}

	private static int aux_gcd(int a, int m) {
		if (m == 0) {
			return a;
		}
		return aux_gcd(m, a % m);

	}

	private static int mod(String b, int a) {
		int curr = Integer.parseInt(b.charAt(0) + "");
		for (int i = 1; i < b.length(); i++) {
			curr = (curr % a) * 10 + Integer.parseInt(b.charAt(i) + "");
		}
		// System.out.println(curr%a);
		return curr % a;
	}

}
