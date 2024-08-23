package memoryLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class MemoryLayout {

	public static void main(String[] args) {
//		System.out.println(VM.current().details());
//		System.out.println(ClassLayout.parseClass(ArrayList.class).toPrintable());
//		System.out.println(ClassLayout.parseClass(Simpleclass.class).toPrintable());
		System.out.println(ClassLayout.parseInstance(new Simpleclass()).toPrintable());
//		List<String> list =new ArrayList<>();
//		System.out.println(ClassLayout.parseInstance(list).toPrintable());
//		list.add("one");
//		System.out.println(ClassLayout.parseInstance(list).toPrintable());
//		System.out.println(ClassLayout.parseInstance(new HashMap<>()).toPrintable());
//		System.out.println(ClassLayout.parseClass(HashMap.class).toPrintable());

//		HashMap<Object, Object> hashMap = new HashMap<>();
//		hashMap.put("key", "value");
//		System.out.println(GraphLayout.parseInstance(hashMap).toFootprint());

	}

}
 class Simpleclass {
	 int a;      // 4 bytes
	 long b;     // 8 bytes
	 byte c;     // 1 byte
	 boolean d;  // 1 byte

}
