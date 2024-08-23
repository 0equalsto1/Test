package leetcode.intrv;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	static int[] arr = new int[26];

	public static void main(String[] args) {
		String s1 = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "jklmnopqrstuvwxyzabcdefghi";
		long s = System.currentTimeMillis();
		System.out.println(isAnagram(s1, s2) + " \ntime taken: " + (System.currentTimeMillis() - s) + "ms");
		s = System.currentTimeMillis();
		System.out.println(isAnagram2(s1, s2) + " \ntime taken: " + (System.currentTimeMillis() - s) + "ms");
		s = System.currentTimeMillis();
		System.out.println(isAnagram3(s1, s2) + " \ntime taken: " + (System.currentTimeMillis() - s) + "ms");
	}

	private static boolean isAnagram(String s1, String s2) {

		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length(); i++) {
			arr[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

	private static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] arr = new int[26];
		for (int i = 0; i < t.length(); i++) {
			arr[s.charAt(i) - 'a'] += 1;
			arr[t.charAt(i) - 'a'] -= 1;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram3(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> frequencyMap = frequencyMap(s);
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			Integer e = frequencyMap.get(c);
			if (e != null && e > 0) {
				frequencyMap.put(c, e - 1);
			} else
				return false;
		}
		return true;

	}

	public static Map<Character, Integer> frequencyMap(String input) {
		Map<Character, Integer> frequencies = new HashMap<>();
		for (char ch : input.toCharArray())
			frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
		return frequencies;
	}
}
