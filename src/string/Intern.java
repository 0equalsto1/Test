package string;

public class Intern {
	String var1 = "length: 10";

	final String var2 = "length: " + "10";
//	String var2 = "length: 10";

	public static void main(String[] args) {
		Intern x = new Intern();
		System.out.println(x.var1 == x.var2);
	}

}
