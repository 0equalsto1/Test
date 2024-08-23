package collection;

import java.util.List;

class ParameterVsRawaTypes{
	
<E> void method1(List<E> list){}

void method2(List<?> list){}

public static <E> void funct1(final List<E> list) {
	list.add(list.get(0));
	// list.add(new Integer(2));
}

public static void funct2(final List<? extends Number> list) {
	//list.add(new Integer(2)); 
    //list.add(list.get(0)); 
}


  public static <T extends Number> void funct3(final List<T> list) {
    list.add(list.get(0));
}
  public static  void funct4(final List<? super Integer> list) {
//	    list.add(list.get(0));
	}

}