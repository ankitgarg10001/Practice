package core_java;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class PassByExample {
	class a {
		int x = 1;

		public a() {
			System.out.println("constructor called");
		}

		public void method1() {
			System.out.println("M1" + x);
			method2();
		}

		public void method2() {
			System.out.println("M2");
		}
	}

	class b extends a {
		int x = 2;

		public b() {
			System.out.println("child constructor called");
		}

		public void method1() {
			System.out.println("M1 child" + x);
			super.method1();
		}

		public void method2() {
			System.out.println("M2 child");
		}
	}

	class c {
		int i;

		public c(int i) {
			this.i = i;
		}
	}

	public static void main(String[] args) {
		PassByExample p = new PassByExample();

		HashSet<c> h = new HashSet<>();
		h.add(p.new c(1));
		h.add(p.new c(1));
		System.out.println(h.size());
	}

	private static void update(PassByExample x, b b) {
		b.x = 5;
		b = x.new b();
		System.out.println("Inside" + b.x);

	}

}
