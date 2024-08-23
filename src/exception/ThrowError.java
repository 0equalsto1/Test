package exception;

public class ThrowError {
	public static void test() {
		throw new Error("error");
	}

	public static void main(String[] args) {
		try {
			ThrowError.test();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end...................");
	}
}
