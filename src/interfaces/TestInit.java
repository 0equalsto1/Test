package interfaces;

public class TestInit extends CDefault implements InDefaultMethods1, InDefaultMethods2 {
	static int out(String s, int i) {
		System.out.println(s + "=" + i);
		return i;
	}

	public static void main(String[] args) {
		System.out.println(A.i);
		System.out.println(A.j);
		TestInit testInit = new TestInit();
		testInit.m1();
	}

}

interface A {
	int i = 19;// new Random().nextInt(10);
	int j = TestInit.out("a", 3);
}

class CDefault {
	public void m1() {
		System.out.println("CDefault m1");
	}
}