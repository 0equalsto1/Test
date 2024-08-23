package concurrency;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService execotorService = Executors.newFixedThreadPool(5);
		ExecutorService execotorService = ForkJoinPool.commonPool();
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " whatsYourNameFuture " + new Date().getTime());
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Rajeev";
		},execotorService);

//		whatsYourNameFuture.complete("Mannu ");
		System.out.println(whatsYourNameFuture.get());
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApplyAsync(name -> {
			System.out.println(Thread.currentThread().getName() + " greetingFuture " + new Date().getTime());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello " + name;
		},execotorService).thenApplyAsync(e -> e + " again " + Thread.currentThread().getName(),execotorService);
		System.out.println(Thread.currentThread().getName() + " after greetingFuture " + new Date().getTime());
		System.out.println(greetingFuture.get()); // Hello Rajeev
		System.out.println("main ends............");
		execotorService.shutdownNow();
	}

}