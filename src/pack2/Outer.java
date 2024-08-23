package pack2;

public class Outer {
int a;
public  class Inner{}
}
class Test extends Outer.Inner{
	Test(){
		new Outer().super();
	}
}
