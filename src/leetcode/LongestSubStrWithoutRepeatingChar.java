package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChar {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bacabcbbcde"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int a = 0;
		int b = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while (b < s.length()) {
			char c = s.charAt(b);
			if (!set.contains(c)) {
				set.add(c);
				b++;
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(a++));
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0)
			return 0;
		//"abba"
		HashMap<Character, Integer> map = new HashMap<>(s.length(), 1.0f);
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
