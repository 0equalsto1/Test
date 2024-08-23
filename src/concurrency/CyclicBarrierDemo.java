package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String args[]) {

		final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println("\nAll bikers have arrived to checkpoint. Lets refill the petrol\n");
			}
		});

		Thread biker1 = new Thread(new Biker(checkPoint), "Biker Thread 1");
		Thread biker2 = new Thread(new Biker(checkPoint), "Biker Thread 2");
		Thread biker3 = new Thread(new Biker(checkPoint), "Biker Thread 3");
		Thread biker4 = new Thread(new Biker(checkPoint), "Biker Thread 4");

		biker1.start();
		biker2.start();
		biker3.start();
		biker4.start();
		System.out.println(Thread.currentThread().getName() + " ends......");

	}
}

class Biker implements Runnable {

	private CyclicBarrier checkPoint;

	public Biker(CyclicBarrier checkPoint) {
		this.checkPoint = checkPoint;
	}

	@Override	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has left Manali");

			System.out.println(checkPoint.await());
			System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");

			System.out.println(checkPoint.await());
			System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");

			System.out.println(checkPoint.await());
			System.out.println(Thread.currentThread().getName() + " has reached Leh");

		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}
	}
}