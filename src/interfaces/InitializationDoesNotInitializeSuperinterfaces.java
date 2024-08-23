package interfaces;

interface I {
	int i = 1, ii = InitializationDoesNotInitializeSuperinterfaces.out("ii", 2);
}

interface J extends I {
	int j = InitializationDoesNotInitializeSuperinterfaces.out("j", 3),
			jj = InitializationDoesNotInitializeSuperinterfaces.out("jj", 4);
}

interface K extends J {
	int k = InitializationDoesNotInitializeSuperinterfaces.out("k", 5);
}

public class InitializationDoesNotInitializeSuperinterfaces {
	public static void main(String[] args) {
		System.out.println(J.i);
		System.out.println(K.j);
	}

	static int out(String s, int i) {
		System.out.println(s + "=" + i);
		return i;
	}
}