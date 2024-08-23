package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            executorService.execute(getRunnable(taskNo));
        }
//        Thread.sleep(100);
        executorService.shutdown();
        System.out.println("main ended................");
    }

    private static Runnable getRunnable(int taskNo) {
        return () -> {
            System.out.println(currentThread().isDaemon());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currentThread().getName() + ": Task " + taskNo);
        };
    }
}
