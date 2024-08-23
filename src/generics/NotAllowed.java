package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class NotAllowed {
public static final String s = "Mannu Rawat";
public static void printList(List<Object> list) {
    for (Object elem : list)
        System.out.println(elem + " ");
    System.out.println();
}
public static void main(String[] args) throws IOException {
	List<Employee> elst = new ArrayList<>();
	elst.add(new Hr());
	List<Object> lst = new ArrayList<>();
	String s="qqq";
	lst.add(s);
	lst.add(new HashSet<>());
	System.out.println(lst);
	/*List<String> ls = new ArrayList<>(); // 1
	List<Object> lo = ls;
	Number[] num = new Integer[] {};
	List<String>[] lsa = new List<String>[10];
	Collection<?> c = new ArrayList<String>();
	c.add(new Object());
	
	Collection<Number> c = new ArrayList<Integer>();*/
	
	List<?>[] lsa = new List<?>[10];
	Object o = lsa;
	List list = new ArrayList<String>();
//	List<?> list1 = new ArrayList<?>();
	
	Object[] strings = new String[2];
	strings[0] = "hi";   // OK
	strings[1] = 100;
	
//	List<?>[] arrayOfLists = new ArrayList<String>[2];
	
	List<Number> box = new ArrayList<Number>();
	box.add(new Integer(10));   // OK
	box.add(new Double(10.1));
//	System.out.println(finallyy());
	
}
/*public static <T> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e > elem)  // compiler error
            ++count;
    return count;
}*/
public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
    return count;
}
public static <T extends Exception, J> void execute(List<J> jobs) {
	 
}
/*<T> T[] makeArray(T t) {
    return new T[100]; // Error.
}*/
public static int finallyy() throws IOException {
	FileInputStream fi = null;
	try {
		fi =new FileInputStream("C:\\Users\\mahendrarawat\\Desktop\\info.txt");
		System.out.println("fi.read()");
		fi.close();
		return 13;
	} finally {
		System.out.println("finalllyyyy.....");
		if(fi!=null)
			fi.close();
		return 11;
	}
	
}
}
