package custom.impl;

class Queue {
	int front, rear, size;
	int capacity;
	int array[];

	public Queue(int size) {
		capacity = size;
		array = new int[capacity];
	}

	boolean isFull() {
		return size == capacity;
	}

	boolean isEmpty() {
		return size == 0;
	}

	void enqueue(int item) {
		if (isFull())
			return;

		array[rear] = item;
		rear = (rear + 1) % capacity;
		size++;
		System.out.println(item + " enqueued to queue");
	}

	int dequeue() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		int item = array[front];
		front = (front + 1) % capacity;
		size--;
		return item;
	}

	int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return array[front];
	}

	int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return array[rear - 1];
	}
}

public class QueueImpl {
	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());
	}
}
