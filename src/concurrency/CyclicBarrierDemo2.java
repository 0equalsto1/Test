package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {

	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {

		final CyclicBarrier checkPoint = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("All bikers reached....");
			}
		});

		Thread biker1 = new Thread(new Biker2(checkPoint), "Biker2 Thread 1");
		Thread biker2 = new Thread(new Biker2(checkPoint), "Biker2 Thread 2");
		Thread biker3 = new Thread(new Biker2(checkPoint), "Biker2 Thread 3");
		Thread biker4 = new Thread(new Biker2(checkPoint), "Biker2 Thread 4");
		List<Thread> list = new ArrayList<>();
		list.add(biker1);
		list.add(biker2);
		list.add(biker3);
		list.add(biker4);
		for (Thread thread : list) {
			thread.start();
			checkPoint.await();
		}
		System.out.println(Thread.currentThread().getName() + " ends......");

	}
}

class Biker2 implements Runnable {

	private CyclicBarrier checkPoint;

	public Biker2(CyclicBarrier checkPoint) {
		this.checkPoint = checkPoint;
	}

	@Override
	public void run() {
		try {
			checkPoint.await();

		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}
	}
}