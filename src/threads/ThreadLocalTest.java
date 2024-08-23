package threads;

public class ThreadLocalTest {

	public static void main(String[] args) {
		ThreadLocal<Integer> lo = new ThreadLocal<>();
		ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	}

}
