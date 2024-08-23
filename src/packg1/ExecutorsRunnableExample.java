package packg1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsRunnableExample {
  private static final int NTHREDS = 5;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS,new MyThreadFactory());
    //System.out.println(Thread.currentThread()+"-------- ");
    for (int i = 1; i <20; i++) {
      Runnable worker = new MyRunnable();
      executor.execute(worker);
    }
    // This will make the executor accept no new threads
    // and finish all existing threads in the queue
    executor.shutdown();
    // Wait until all threads are finish
    executor.awaitTermination(1, TimeUnit.SECONDS);
    System.out.println("Finished all threads");
  }
} 

 class MyRunnable implements Runnable {
	  /*private final long countUntil;

	  MyRunnable(long countUntil) {
	    this.countUntil = countUntil;
	  }*/

	  @Override
	  public void run() {
	    
	   // System.out.println(Thread.currentThread()+" "+countUntil);
		  URL url;

		    try {
		        // get URL content

		        String a="http://localhost:8080/mannu";
		        url = new URL(a);
		        Object conn = url.openConnection().getContent();

		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    
	  }
	} 
 class MyThreadFactory implements ThreadFactory {
	   
	   AtomicInteger atom = new AtomicInteger(1);
	   @Override
	public Thread newThread(Runnable r) {
	     return new Thread(r, "mannu"+atom.getAndIncrement());
	   }
	 }