package packg1;

class A{
	 void throwException(Exception e){
		System.out.println("Inside A");
	}
}
class B extends A{
	@Override
	void throwException(Exception e){
		System.out.println("Inside B");
	}
	
}
public class PolyMorphism {
	public static void main(String[] args) {
		A objA1=new A();
		A objA2=new B();
		objA1.throwException(new RuntimeException());
		objA2.throwException(new RuntimeException());
	}
}
