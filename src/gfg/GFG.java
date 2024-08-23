package gfg;
/*package whatever //do not write package name here */

class GFG {
	public static void main(String[] args) {
		// code
		rotateArry(new int[] { 1, 2, 3, 4, 5 }, 5, 2);
		int s1 = 2;
		int s2 = 20;
		int n = 50;
		if (s1 == s2) {
			System.out.println((s1 * n) / 2);
			return;
		}

		int min = s1 > s2 ? s2 : s1;
		int max = s1 > s2 ? s1 : s2;
		int minTotal = min * n;

		if (max >= minTotal) {
			System.out.println(min * n);
			return;
		}
		/*int time = 0;
		int d = 0;
		int i = 1;
		while (d < n) {
			time = time + min;
			if (time >= min * n) {
				time = max;
				d = n;
				break;
			}
			d++;
		
			if (time > (max * i)) {
				d++;
				i++;
			}
		}*/
//		System.out.println(time);

		int k = s2 * n / (s1 + s2);
		k = k + 1;
//		System.out.println(s1 * k);

	}

	static void rotateArry(int a[], int n, int d) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		/*int newArry[] = new int[a.length];
		
		for (int i = 0; i < n; i++) {
			int newIndex = (i + n - d) % n;
			newArry[newIndex] = a[i];
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(newArry[i] + " ");
		}
		System.out.println();*/
		for (int i = 0; i < n; i++) {
//			System.out.print(a[(i + d) % n] + " ");
			int in = i + d;
			if (in < n)
				System.out.print(a[in] + " ");
			else
				System.out.print(a[in - n] + " ");

		}
	}
}