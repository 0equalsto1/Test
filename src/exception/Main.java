package exception;

import java.io.IOException;

// A Simple Java program to demonstrate 

// method overriding in java 

// Base Class 
class Parent {
	void show() throws IOException {
		System.out.println("Parent's show()");
	}
}

// Inherited class 
class Child extends Parent {
	// This method overrides show() of Parent
	@Override
	void show() {
		System.out.println("Child's show()");
	}
}

// Driver class 
public class Main {
	public static void main(String[] args) throws IOException {
		
		Parent obj2 = new Child();
		obj2.show();
	}
}
