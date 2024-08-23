package leetcode.intrv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrangeWords {

	public static void main(String[] args) {
		System.out.println(arrange("Here i come."));
	}

	public static String arrange(String sentence) {
		Map<Integer, List<String>> map = new TreeMap<>();
		sentence = sentence.substring(0, sentence.length() - 1);
		for (String s : sentence.toLowerCase().split(" ")) {
			int l = s.length();
			List<String> values = map.getOrDefault(l, new ArrayList<>());
			values.add(s);
			map.put(l, values);
		}
		StringBuilder sb = new StringBuilder(sentence.length() + 1);
		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {

			for (String s : entry.getValue()) {
				sb.append(s).append(" ");
			}
		}
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		sb.setCharAt(sb.length()-1, '.');
		return sb.toString();
	}

}
