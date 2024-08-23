package packg1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingltonInThreads {
		public static void main(String[] args) {
			ExecutorService executor = Executors.newFixedThreadPool(2);
			for(int i=0;i<2;i++){
				Runnable runable = new MyyRunnable(i+1);
				executor.execute(runable);
			}
			executor.shutdown();
	}
}

class Singlton {
	private static final Singlton obj = new Singlton();
	private int i;

	private Singlton() {
	}

	public static Singlton getObj() {

		return obj;

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
class MyyRunnable implements Runnable {
	 int j;
	 Singlton obj;
	public MyyRunnable(int i){
		j=i;
	}
	  @Override
	  public synchronized void  run() {
		  System.out.println(Thread.currentThread().getName()+"  j= "+j);
		   
	    try {
	    	obj = Singlton.getObj();
	    	Thread.sleep(3000);
			  obj.setI(j);
			
			System.out.println(Thread.currentThread().getName()+" "+obj.getI());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	} 