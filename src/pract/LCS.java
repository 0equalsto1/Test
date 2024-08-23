package pract;

public class LCS {

	public static void main(String[] args) {
//		"abcde"
//		"ace"
//		"ezupkr"
//		"ubmrapg"
//		"oxcpqrsvwf"
//		"shmtulqrypy"
//		"bsbininm"
//		"jmjkbkjkv"
		String text1 = "oxcpqrsvwf";
		String text2 = "shmtulqrypy";
		char[] x = text1.toCharArray();
		char[] y = text2.toCharArray();
		int m = x.length;
		int n = y.length;
		int max = 0;
		int tmp = 0;
		int i = 0;
		int j = 0;
		char a = 0;
		char b = 0;
		int index = 0;
		for (; i < m; i++) {
			for (; j < n;) {
				a = x[i];
				b = y[j];
				if (a == b) {
					tmp++;
					j++;
					index = j;
					break;
				}
				j++;
			}
			System.out.println(a + "  " + b);
			if (j >= n) {
				if (tmp == 0)
					j = 0;
				else
					j = index;

			}
		}
		System.out.println(tmp);
		System.out.println(i + "  " + j);
	}
}
