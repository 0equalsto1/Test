package pack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapInternal {
	transient int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public static void main(String[] args) {
		List<Map<String,String>> list = new ArrayList<>();
		System.out.println("jasj"+null);
		Map<String,String> map=new HashMap<>(1,1.0f);
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		System.out.println(list.isEmpty());
		list.add(map);
		HashMap<String,String> copy = new HashMap<>();
    for (Map<String,String> entry : list)
    {
        System.out.println("asdgggggg");
    }
//    System.out.println(map);
//    System.out.println(copy);
//    System.out.println("*********************************************");
//    copy.put("4", "four");
//    System.out.println(map);
//    System.out.println(copy);
    System.out.println(40>>>1);
    System.out.println(40<<2);
	}
}
