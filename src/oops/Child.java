package oops;

class Parent {
	public Parent() {
	}

	public void print() {
	}
}

public class Child extends Parent {
//	public Parent() {
//	}

	public void print() {
	}

	public static void main(String[] args) {
		Child c1 = new Child(); // allowed
//		Child c2 = new Parent(); // not allowed
	}
}