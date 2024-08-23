package threads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

//@formatter:off
public class MyThr {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRun("mannu"), "t1");
		Thread t2 = new Thread(new MyRun("mannu"), "t2");
		Thread t3 = new Thread(new MyRun("mannu"), "t3");
		Thread t4 = new Thread(new MyRun("mannu"), "t4");
		t1.start();		t2.start();		t3.start();		t4.start();
	}
}
//@formatter:on
class MyRun implements Runnable {
	String id;

	public MyRun(String id) {
		this.id = id;
	}

	public void run() {
		TestSynchronized.run(id);
	}
}

class TestSynchronized {
	public static void run(String id) {
		synchronized (id) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + new Date());
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}