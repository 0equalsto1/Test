package intrv_slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOccurrencesOfAnagrams {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
		System.out.println(findAnagramsUsingMap(s, p));
	}

	public static List<Integer> findAnagramsUsingMap(String str, String pattrn) {
		int strLen = str.length();
		int pattnLen = pattrn.length();
		List<Integer> res = new ArrayList<>();

		if (strLen <= 0 || pattnLen <= 0)
			return res;
		Map<Character, Integer> frequencyMap = frequencyMap(pattrn);
		int count = frequencyMap.size();
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			Integer e = frequencyMap.get(c);
			if (e != null) {
				int value = e - 1;
				frequencyMap.put(c, value);
				if (value == 0)
					count--;
			}
			if (i + 1 >= pattnLen) {
				int strt = i + 1 - pattnLen;
				if (count == 0) {
					res.add(strt);
				}
				c = str.charAt(strt);
				e = frequencyMap.get(c);
				if (e != null) {
					int value = e + 1;
					frequencyMap.put(c, value);
					if (value == 1)
						count++;
				}

			}
		}
		return res;

	}

	public static List<Integer> findAnagrams(String str, String pattrn) {
		int strLen = str.length();
		int pattnLen = pattrn.length();
		List<Integer> res = new ArrayList<>();
		if (strLen <= 0 || pattnLen <= 0)
			return res;

		int[] pattrnArr = new int[26];
		for (int i = 0; i < pattnLen; i++) {
			char c = pattrn.charAt(i);
			pattrnArr[c - 'a']++;
		}

		int[] strArr = new int[26];
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			strArr[c - 'a']++;
			if (i + 1 >= pattnLen) {
				if (Arrays.equals(pattrnArr, strArr))
					res.add(i + 1 - pattnLen);
				char c2 = str.charAt(i + 1 - pattnLen);
				strArr[c2 - 'a']--;
			}
		}

		return res;
	}

	public static Map<Character, Integer> frequencyMap(String input) {
		Map<Character, Integer> frequencies = new HashMap<>();
		for (char ch : input.toCharArray())
			frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
		return frequencies;
	}

}
