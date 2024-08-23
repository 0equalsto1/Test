package collection.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListSwap {
	public static void main(String[] args) {
		ArrayList<String> list2 = new ArrayList<>(100);
		list2.add("100");
		ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
		List<LanguageData> ll = new LinkedList<>();
		LanguageData l1 = new LanguageData();
		l1.setIs_prefered(0);
		l1.setLanguage("l1");
		LanguageData l2 = new LanguageData();
		l2.setIs_prefered(1);
		l2.setLanguage("l2");
		LanguageData l3 = new LanguageData();
		l3.setIs_prefered(1);
		l3.setLanguage("l3");
		ll.add(l1);
		ll.add(l2);
		ll.add(l3);
		ll.sort((LanguageData o1, LanguageData o2) -> o1.getIs_prefered() - o2.getIs_prefered());
		System.out.println(ll);

//		Collections.swap(list, 1, 2);

//		System.out.println(list);
//		rearrange();
	}

	public static void rearrange() {
		List<String> list = new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
		System.out.println(list);
		int indexOf = list.indexOf("z");
		String remove = list.remove(indexOf);
		list.add(0, remove);
		System.out.println(list);
	}
}