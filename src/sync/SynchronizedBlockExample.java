package sync;

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        SynchronizedBlockExample example = new SynchronizedBlockExample();


        Runnable task1 = () -> example.updateMessage("m1");
        Runnable task2 = () -> example.updateMessage("m2");
        Runnable task3 = () -> example.updateMessage("m3");

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task1, "Thread 2");
        Thread thread3 = new Thread(task2, "Thread 3");
        Thread thread4 = new Thread(task3, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void updateMessage(String newMessage)  {
        synchronized (newMessage) {
            System.out.println(newMessage+" : " +Thread.currentThread());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
