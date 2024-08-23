package packg1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
public class ExecutorsCallableExample {
	
  private static final int NTHREDS = 5;
  
  public static void main(String[] args) throws ExecutionException, InterruptedException {
	  //AtomicInteger atom = new AtomicInteger(1);
    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    List<Future<Long>> list = new ArrayList<Future<Long>>();
    for (int i = 0; i <10; i++) {
      Callable<Long> worker = new MyCallable(i+2);
      Future<Long> submit = executor.submit(worker);
      list.add(submit);
    }
    long sum = 0;
    //System.out.println(list.get(8).get(3, TimeUnit.SECONDS));
    // now retrieve the result
    for (Future<Long> future : list) {
      try {
        try {
			sum = future.get(1,TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			future.cancel(true);
			System.out.println(e.getClass());
		System.out.println("TimeOut");
		}
        System.out.println(sum);
      } 
      catch (InterruptedException e) {
    	  System.out.println(e.getClass());
      } catch (ExecutionException e) {
    	  System.out.println(e.getClass());
      } 
      
    }
    //System.out.println(Thread.currentThread()+" ="+sum);
    executor.shutdown();
  }
}

 class MyCallable implements Callable<Long> {
	 int j;
	 MyCallable(int x){
		 j=x;
	 }
  @Override
  public Long call() throws Exception {
    long sum = 0;
    for (long i =0; i <j; i++) {
    	//System.out.println("j = "+j);
      sum += i;
    }
    TimeUnit.MICROSECONDS.sleep(5000);
    return sum;
  }
 }
