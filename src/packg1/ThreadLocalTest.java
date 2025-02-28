package packg1;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 
 * @author Mahendra Rawat
 *
 */
public class ThreadLocalTest {

	 public static class MyRunnable implements Runnable {

	        private ThreadLocal<Integer> threadLocal =
	               new ThreadLocal<>();

	        @Override
	        public void run() {
	            threadLocal.set( (int) (Math.random() * 500D) );
	    
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	            }
	    
	            System.out.println(threadLocal.get());
	        }
	    }


	    public static void main(String[] args) throws InterruptedException {
	        MyRunnable sharedRunnableInstance = new MyRunnable();

	        Thread thread1 = new Thread(sharedRunnableInstance);
	        Thread thread2 = new Thread(sharedRunnableInstance);

	        thread1.start();
	        thread2.start();

	        //thread1.join(); //wait for thread 1 to terminate
	        //thread2.join(); //wait for thread 2 to terminate
	    }
}







