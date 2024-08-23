package custom.impl;

public class Stack {
	private int[] arr;
	private int top;

	Stack(int size) {
		arr = new int[size];
		top = -1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public boolean push(int data) {
		if (top >= arr.length - 1)
			return false;
		arr[++top] = data;
		return true;
	}

	public int pop() {
		if (top > -1)
			return arr[top--];
		return -1;

	}

	public int peek() {
		if (top > -1)
			return arr[top];
		return -1;

	}

	public static void main(String[] args) {
		Stack s = new Stack(5);
		System.out.println(s.push(1));
		System.out.println(s.push(2));
		System.out.println(s.push(3));
		System.out.println(s.push(4));
		System.out.println(s.push(5));
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
