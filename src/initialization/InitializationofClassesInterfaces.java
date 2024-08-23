package initialization;

public class InitializationofClassesInterfaces {

	public static void main(String[] args) {
		System.out.println(TestStatic.n);
		//TestStatic t = new TestStatic();
	}

}

class TestStatic {
	public static final int n = 100;
	static {
		System.out.println("inside static block....");
	}
}