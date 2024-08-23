package enums;

enum EnumEx1{
	A,B,C;
	EnumEx1(){
		System.out.println("C");
	}
}
public class EnumConcept {

	public static void main(String[] args) {
		EnumEx1 ex = EnumEx1.A;
		System.out.println(ex);

	}

}
