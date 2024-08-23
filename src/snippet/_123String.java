package snippet;

public class _123String {
	static void sortArr(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 1: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 2:
				mid++;
				break;
			case 3: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	public static void main(String[] args) {

//		int[] arr = { 1, 2, 2, 1, 1, 3, 1, 1, 3, 2 };
		int[] arr = { 3, 2, 2, 3, 1};

//		sortArr(arr, arr.length);
		sortArr(arr);
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
	}

	static void sortArr(int arr[]) {
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				a++;
			else if (arr[i] == 2)
				b++;
			else
				c++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (i < a)
				arr[i] = 1;
			else if (i < a+b)
				arr[i] = 2;
			else
				arr[i] = 3;
		}
	}

}
