package pack2;

public class WaitNotify {
	public static void main(String[] args) {
		WaitNotifyRunnable run = new WaitNotifyRunnable();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		t1.start();
		t2.start();
	}
}

class WaitNotifyRunnable implements Runnable {
	boolean b = false;
	static String s = "";

	/*@Override
	public synchronized void  run() {
		if(b){
			System.out.println("pong");
		}else{
			System.out.println("ping");
			b=true;
		}
	}
	*/ @Override
	public synchronized void run() {
		if (s.equals("ping")) {
			System.out.println(s = "pong");
		} else if (s.equals("")) {
			System.out.println(s = "ping");

		}
	}

}