package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String args[]) {

		final CountDownLatch latch = new CountDownLatch(4);
		Thread emp1 = new Thread(new Employee("EMP 1", 1000, latch));
		Thread emp2 = new Thread(new Employee("EMP 2", 1000, latch));
		Thread emp3 = new Thread(new Employee("EMP 3", 1000, latch));
		Thread emp4 = new Thread(new Employee("EMP 4", 1000, latch));

		emp1.start();
		emp2.start();
		emp3.start();
		emp4.start();


		try {
			latch.await();
			System.out.println("All employees have taken their seat, Driver started the car");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

class Employee implements Runnable {
	private final String name;
	private final int timeToReachParking;
	private final CountDownLatch latch;

	public Employee(String name, int timeToReachParking, CountDownLatch latch) {
		this.name = name;
		this.timeToReachParking = timeToReachParking;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToReachParking);
		} catch (InterruptedException ex) {
			System.err.println("Error : ");
			ex.printStackTrace();
		}
		System.out.println(name + " has taken his seat");
		latch.countDown();
	}

}