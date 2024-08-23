package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

	public static void main(String args[]) {

		final CountDownLatch latch = new CountDownLatch(4);
		Thread emp1 = new Thread(new Employee2("EMP 1", 1000, latch));
		Thread emp2 = new Thread(new Employee2("EMP 2", 1000, latch));
		Thread emp3 = new Thread(new Employee2("EMP 3", 1000, latch));
		Thread emp4 = new Thread(new Employee2("EMP 4", 1000, latch));

		emp1.start();
		emp2.start();
		emp3.start();
		emp4.start();


		try {
			for(int i=0;i<4;i++) {
				Thread.sleep(3000);
				latch.countDown();
			}
			System.out.println("All employees have taken their seat, Driver started the car");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

class Employee2 implements Runnable {
	private final String name;
	private final int timeToReachParking;
	private final CountDownLatch latch;

	public Employee2(String name, int timeToReachParking, CountDownLatch latch) {
		this.name = name;
		this.timeToReachParking = timeToReachParking;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			
			Thread.sleep(timeToReachParking);
			System.out.println(name + " waiting...");
			latch.await();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(name + " has taken his seat");
	}

}