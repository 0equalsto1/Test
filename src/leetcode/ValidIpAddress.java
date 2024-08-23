package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddress {

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("24825211135"));
		System.out.println(restoreIpAddresses("248252111353"));
		//[255.255.11.135, 255.255.111.35]

//		System.out.println(restoreIpAddresses("25505011535"));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		int n = s.length();
		if (n < 4 || n > 12)
			return res;
		
		for (int i = 1; i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValid(first))
				continue;
			for (int j = 1; i + j < n && j < 4; j++) {
				String second = s.substring(i, i + j);
				if (!isValid(second))
					continue;
				for (int k = 1; i + j + k < n && k < 4; k++) {
					String third = s.substring(i + j, i + j + k);
					String fourth = "";
					if (!isValid(third) || !isValid(fourth = s.substring(i + j + k)))
						continue;
					res.add(first + "." + second + "." + third + "." + fourth);
				}
			}
		}
		return res;

	}

	private static boolean isValid(String s) {
		if (s.startsWith("0") && s.length() > 1)
			return false;
		int val = Integer.parseInt(s);
		return val >= 0 && val <= 255;
	}
}
