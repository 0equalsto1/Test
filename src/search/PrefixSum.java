package search;

public class PrefixSum {

	public static void main(String[] args) {
//		String s = "";
//		String s = "ababaa";
		String s = "";
		long st = System.currentTimeMillis();
		System.out.println(stringSimilarity1(s) + "  time taken : " + (System.currentTimeMillis() - st) + "ms");
		System.out.println(stringSimilarity2(s) + "  time taken : " + (System.currentTimeMillis() - st) + "ms");
		System.out.println(stringSimilarity3(s) + "  time taken : " + (System.currentTimeMillis() - st) + "ms");

	}

	public static int stringSimilarity1(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int loop = 0;
		int count = s.length();
		StringBuilder sf = new StringBuilder();
		for (int i = s.length() - 1; i > 0; i--) {
			char c = s.charAt(i);
			sf.insert(0, c);
			if (c == s.charAt(0)) {
				count++;
				for (int j = 1; j < sf.length(); j++) {
					loop++;
					if (sf.charAt(j) != s.charAt(j))
						break;
					count++;
				}
			}
		}
		System.out.print("loop : " + loop + " stringSimilarity1: ");
		return count;
	}

	public static int stringSimilarity2(String s) {
		int l = s.length();
		int count = l;
		int[] arr = new int[l];
		int loop = 0;
		for (int i = 1; i < l; i++) {
			while (i + arr[i] < l && s.charAt(arr[i]) == s.charAt(i + arr[i])) {
				loop++;
				++arr[i];
				count++;
			}
		}
		System.out.print("loop : " + loop + " stringSimilarity2: ");

		return count;
	}

	public static int stringSimilarity3(String s) {
		int l = s.length();
		int count = l;
		int loop = 0;
		for (int i = 1; i < l; i++) {
			int j = 0;
			while (i + j < l && s.charAt(j) == s.charAt(j + i)) {
				loop++;
				j++;
				count++;
			}
		}
		System.out.print("loop : " + loop + " stringSimilarity3: ");

		return count;
	}
}
