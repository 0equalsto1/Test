package virtual;

public class Vthread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.startVirtualThread(Vthread::run);
        thread.join(8000);
    }

    private static void run() {
        try {
            Thread.sleep(5000);
            System.out.println("vvvvvvvvvvvvvvv   "+Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
