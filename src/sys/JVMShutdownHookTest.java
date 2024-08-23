package sys;

import java.util.concurrent.TimeUnit;

public class JVMShutdownHookTest {
	public static void main(String[] args) {
		JVMShutdownHook jvmShutdownHook = new JVMShutdownHook();
		Runtime.getRuntime().addShutdownHook(jvmShutdownHook);
		System.out.println("JVM Shutdown Hook Registered.");
		System.out.println("Pre exit.");
		System.exit(0);
		System.out.println("Post exit.");
	}

	private static class JVMShutdownHook extends Thread {
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("JVM Shutdown Hook: Thread initiated.");
		}
	}
}