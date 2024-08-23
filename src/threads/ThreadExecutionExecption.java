package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExecutionExecption {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		try {
			System.out.println(Thread.currentThread().getName());
			Future<String> submit = executor.submit(new ThExeExap());
//			submit.get();
		} catch (Exception e) {
			System.out.println("====== "+e.getMessage());
		}
		executor.shutdown();

	}

}

class ThExeExap implements Callable<String> {
	public String call() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(1000);
		int i = 9 / 0;
		System.out.println(i);
		return "11";
	}
}