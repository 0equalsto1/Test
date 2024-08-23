package custom.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static java.lang.Thread.currentThread;

public class CustomThreadPool {

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 5; i++) {
            int taskNo = i;
            threadPool.execute(getRunnable(taskNo));
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();

    }

    private static Runnable getRunnable(int taskNo) {
        return () -> {
            try {
//                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String message = currentThread().getName() + ": Task " + taskNo;
            System.out.println(message);
        };
    }
}

class ThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new LinkedBlockingDeque<>(maxNoOfTasks);
        for (int i = 0; i < noOfThreads; i++) {
            runnables.add(new PoolThreadRunnable(taskQueue));
        }
        for (PoolThreadRunnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }

    public void execute(Runnable task) throws Exception {
        if (isStopped)
            throw new IllegalStateException("ThreadPool is stopped");

        taskQueue.offer(task);
    }

    public void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isStopped = true;
        for (PoolThreadRunnable runnable : runnables) {
            runnable.doStop();
        }
    }

}

class PoolThreadRunnable implements Runnable {

    private Thread thread;
    private BlockingQueue<Runnable> taskQueue;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    public void run() {
        thread = currentThread();
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void doStop() {
        isStopped = true;
        thread.interrupt();
    }

    public boolean isStopped() {
        return isStopped;
    }
}