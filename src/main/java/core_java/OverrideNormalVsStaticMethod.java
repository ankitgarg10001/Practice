package core_java;

class Base {
	static void staticMethod() {
		System.out.println("Called static Base method.");
	}

	void instanceMethod() {
		System.out.println("Called non-static Base method.");
	}

	void instanceCallingStaticBase() {
		System.out.println("Non-static calls overridden(?) static:");
		System.out.print("");
		staticMethod();
	}
}

class Child extends Base {
	static void staticMethod() {
		System.out.println("Called static Child method.");
	}

	void instanceMethod() {
		System.out.println("Called non-static Child method.");
	}

	void instanceCallingStaticChild() {
		System.out.println("Non-static calls own static:");
		System.out.print("");
		staticMethod();
	}
}

public class OverrideNormalVsStaticMethod {
	public static void main(String[] args) {
		System.out.println("Reference: Base, Object: Child");
		Base base = new Child();
		base.staticMethod();
		base.instanceMethod();
		System.out.println("Reference: Child, Object: Child");
		Child child = new Child();
		child.staticMethod();
		child.instanceMethod();
		child.instanceCallingStaticChild();
		child.instanceCallingStaticBase();
		System.out.println("Static call by Class");
		Child.staticMethod();
		Base.staticMethod();
	}

}
