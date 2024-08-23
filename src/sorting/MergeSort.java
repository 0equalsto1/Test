package sorting;

class MergeSort {

	static void merge2(int arr[], int start1, int mid, int end) {
		int start2 = mid + 1;

// If the direct merge is already sorted
		if (arr[mid] <= arr[start2]) {
			return;
		}

		while (start1 <= mid && start2 <= end) {

			// If element 1 is in right place
			if (arr[start1] <= arr[start2]) {
				start1++;
			} else {
				int value = arr[start2];
				int index = start2;

				// Shift all the elements between element 1
				// element 2, right by 1.
				while (index != start1) {
					arr[index] = arr[index - 1];
					index--;
				}
				arr[start1] = value;

				// Update all the pointers
				start1++;
				mid++;
				start2++;
			}
		}
	}

	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge2(arr, l, m, r);
		}
	}

	void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			System.out.println("left   l=" + l + " m=" + m + " r=" + r);
			sort(arr, l, m);
			System.out.println("right  l=" + l + " m=" + m + " r=" + r);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 1, 21, 34, 3, 2, 9, 90, 26, 65, 18, 43, 34, 10 };

		System.out.println("Given Array");
		printArray(arr);

		/*MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);*/
		mergeSort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
