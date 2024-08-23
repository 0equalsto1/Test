package concurrency;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public CustomThreadPool(int n) {
		this.nThreads = n;
		queue = new LinkedBlockingQueue<>();
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public static void main(String[] args) {
		CustomThreadPool pool = new CustomThreadPool(4);
		for (int i = 0; i < 11; i++) {
			pool.execute(() -> System.out.println(Thread.currentThread().getName()));
		}
	}

	public void execute(Runnable task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class PoolWorker extends Thread {
		@Override
		public void run() {
			Runnable task = null;

			while (true) {

				try {
					task = queue.take();
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}