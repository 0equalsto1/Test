package packg1;

public class Main {/*

	public static void main(String[] args) throws InterruptedException {
		// Declares the file.
		File file = new File(getPath() + "/cronTab.txt");
		// Creates the scheduler.
		Scheduler scheduler = new Scheduler();
		// Schedules the file.
		scheduler.scheduleFile(file);
		// Starts the scheduler.
		scheduler.start();
		// Stays alive for five minutes.
		Thread.currentThread().join();

		// Stops the scheduler.
		// scheduler.stop();
	}

	public static String getPath() {
		CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
		File jarFile = null;
		try {
			jarFile = new File(codeSource.getLocation().toURI().getPath());
		} catch (URISyntaxException e) {
			System.out.println("IOException in getPath() method :" + e.getMessage());
			System.out.println("Exception in getPath() method :" + e.getMessage());
		}
		@SuppressWarnings("null")
		String jarDir = jarFile.getParentFile().getPath();
		return jarDir;
	}
*/}
