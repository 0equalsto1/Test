package threads;

public class ThreadPrintEvenOdd {
    static class Resource implements Runnable {
        int limit;
        int counter;
        final Object lock = new Object();

        public Resource(int limit) {
            this.limit = limit;
            counter = 0;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (counter < limit) {
                    String threadName = Thread.currentThread().getName();
                    if (threadName.equals("even")) {
                        if (counter % 2 == 0)
                            printAndNotify(threadName);
                        else
                            waitForLock();

                    } else if (counter % 2 != 0)
                        printAndNotify(threadName);
                    else
                        waitForLock();
                }

            }

        }

        private void printAndNotify(String threadName) {
            System.out.println(threadName + " " + counter);
            counter++;
            lock.notify();
        }

        private void waitForLock() {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException ::even");
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new Resource(15);
        Thread t1 = new Thread(r, "even");
        Thread t2 = new Thread(r, "odd");
        t1.start();
        t2.start();

    }

}
