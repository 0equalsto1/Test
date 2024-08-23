package custom.impl;

class MyCircularQueue {

	int front, rear, size;
	int capacity;
	int array[];

	public MyCircularQueue(int k) {
		capacity = k;
		rear = -1;
		array = new int[capacity];
	}

	public boolean enQueue(int value) {

		if (isFull())
			return false;
		rear = (rear + 1) % capacity;
		array[rear] = value;

		size++;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
//		int item = array[front];
		front = (front + 1) % capacity;
		size--;
		return true;
	}

	public int Front() {
		if (isEmpty())
			return -1;

		return array[front];
	}

	public int Rear() {
		if (isEmpty())
			return -1;

		return array[rear];

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1));
		System.out.println(myCircularQueue.enQueue(2));
		System.out.println(myCircularQueue.enQueue(3));
		System.out.println(myCircularQueue.enQueue(4));
		System.out.println(myCircularQueue.Rear());
		System.out.println(myCircularQueue.isFull());
		System.out.println(myCircularQueue.deQueue());
		System.out.println(myCircularQueue.enQueue(4));
		System.out.println(myCircularQueue.Rear());
	}
}