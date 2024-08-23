package packg1;

public class Initblock {
	{
		System.out.println("inside init block......");
	}

	public Initblock() {
		super();
		System.out.println("inside constructor block......");
	}

	public static void main(String[] args) {
		new Initblock();
	}

}
