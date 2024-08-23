package dateAndTime;

import java.util.concurrent.TimeUnit;

public class MilliSeconds {

	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(4);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);

	}

}
