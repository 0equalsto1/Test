package leetcode.intrv;

// Java program to print all permutations of a 
// given string. 
public class Permutation {
	static int j = 0;

	public static void main(String[] args) {
		String str = "ABC";
		permutation("", str);
	}

	public static void permutation(String str) {
		// TODO Auto-generated method stub

	}

	public static void permutation(String prefix, String str) {
//		System.out.println("prefix : "+prefix+" str : "+str);
//		j++;
		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				String beforePreFixPart = str.substring(0, i);
				String afterPreFixPart = str.substring(i + 1, n);
				String prefix2 = prefix + str.charAt(i);
				permutation(prefix2, beforePreFixPart + afterPreFixPart);
			}
		}
	}

}
