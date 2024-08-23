package inerClasses;

class Outer {
	Outer() {
		System.out.println("Outer");
	}

	class Inner {
		Inner() {
			System.out.println("Inner");
		}

		void method() {
			System.out.println("method called");
		}
	}
}

class A extends Outer.Inner {
	A() {
		new Outer().super();
	}
	void method3() {
		System.out.println("method called");
	}
}