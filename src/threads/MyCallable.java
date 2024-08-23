package threads;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		TimeUnit.MINUTES.sleep(5);
		return Thread.currentThread().getName();
	}

	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Callable<String> callable = new MyCallable();
		Future<String> future = executor.submit(callable);
		System.out.println(future.isDone());
		try {
			String string = future.get();
			System.out.println(new Date() + "::" + string);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
