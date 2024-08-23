package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecotorServiceTest {
	public static void main(String[] args) {


		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.submit(new Callable<Integer>() {
		
			@Override
			public Integer call() throws Exception {
				System.out.println("helloooo");
				return 1;
			}
		});
		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		
		executorService.shutdown();
	}
}
