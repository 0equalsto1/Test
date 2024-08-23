package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Timer task started at:" + new Date());
	}


	public static void main(String args[]) {
		TimerTask timerTask = new MyTimerTask();
		Timer timer = new Timer(true);
		try {
			// running timer task as daemon thread
			timer.scheduleAtFixedRate(timerTask, 0, 2 * 1000);
			System.out.println("TimerTask started");
			// cancel after sometime
			Thread.sleep(10*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
	}

}