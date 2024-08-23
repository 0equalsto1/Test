package threads;

public class ThreadsSequence {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyRunnable(1), "1");
		Thread t2 = new Thread(new MyRunnable(2), "2");
		Thread t3 = new Thread(new MyRunnable(3), "3");
		t1.start();
		t2.start();
		t3.start();
		/*
		 * t1.join(); t2.join(); t3.join();
		 */
		System.out.println(Thread.currentThread().getName() + " completed...");
//		System.exit(1);

	}

}

class MyRunnable implements Runnable {

	static int n = 1;
	static int count = 1;
	int tVal;
	static final Object lock = new Object();

	MyRunnable(int val) {
		tVal = val;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (count < 11) {
				try {
					if(n != tVal)
						lock.wait();
					else {
						System.out.println(Thread.currentThread().getName() + " : " + count++);
						if (n == 3)
							n = 1;
						else
							n++;
						lock.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
