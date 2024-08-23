package async;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureT {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Future<String> completableFuture = calculateAsync();
		System.out.println(new Date());
		System.out.println(completableFuture.get());
		System.out.println(new Date());
	}

	public static Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();

	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(5000);
	        completableFuture.complete("Hello");
	        return null;
	    });

	    return completableFuture;
	}
}