package threads;

class ThreadTest {

	int count = 1;
	int N = 3;

	public synchronized void printSerials() {
		while (count <= N) {

			if (Integer.parseInt(Thread.currentThread().getName()) != count) {

				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName());
				count++;
				notifyAll();
			}
		}

	}

}

public class Test {

	public static void main(String[] args) throws InterruptedException {

		ThreadTest tt = new ThreadTest();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				tt.printSerials();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				tt.printSerials();

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				tt.printSerials();

			}
		});
		t1.setName("1");
		t1.start();
		t2.setName("2");
		t2.start();
		t3.setName("3");
		t3.start();

		t1.join();
		t2.join();
		t3.join();

	}

}
