package threads;

import java.util.Date;

public class ThreadSleepVsWaitVsJoin {
	public static void main(String[] args) throws InterruptedException {
		TestRunnable r = new TestRunnable();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("main End : " + new Date());
	}
}

class TestRunnable implements Runnable {
	Object o = new Object();

	@Override
	public void run() {
		synchronized (o) {

			System.out.println(Thread.currentThread().getName() + " " + new Date());
			try {
				//sleep test
//				Thread.sleep(5000);
//				o.wait();
				o.wait(5000);
				System.out.println(Thread.currentThread().getName() + " " + new Date());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}