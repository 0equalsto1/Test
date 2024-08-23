package packg1;

public class ImmutableTest extends Immutable {

	ImmutableTest() {
		System.out.println("In child Cons");
	}
	
@Override
public void super1() {
	System.out.println("child Class Method");
		
	}
public static void main(String[] args) {
	Immutable immutabletest = new ImmutableTest();
	System.out.println(immutabletest.getA());
}
}
class Immutable {
	private final int a;
	Immutable(){
		System.out.println("In Parent Cons");
		super1();
		a=13;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getA(){
		return a;
	}
	public void super1() {
		System.out.println("Parent Class Method");
		
	}
}