package pack2;

public class Neelu {
	public static final Neelu ELVIS = new Neelu();
	
	private Neelu() {
	}

	private static final Boolean LIVING = true;
	private static final Boolean alive = LIVING;

	public final Boolean lives() {
		return alive;
	}

	public static void main(String[] args) {
		System.out.println(ELVIS.lives() ? "aaa" : "bbb");
	}

}
