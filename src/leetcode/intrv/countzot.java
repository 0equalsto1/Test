package leetcode.intrv;
// Java program to sort an array of 0, 1 and 2

class countzot { 

	// Sort the input array, the array is assumed to 
	// have values in {0, 1, 2} 
	static void sort012(int a[], int arr_size) 
	{ 
		int lo = 0; 
		int hi = arr_size - 1; 
		int mid = 0,temp=0; 
		while (mid <= hi) 
		{ 
			switch (a[mid]) 
			{ 
			case 1: 
			{ 
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
			case 3: 
			{ 
				temp = a[mid]; 
				a[mid] = a[hi]; 
				a[hi] = temp; 
				hi--; 
				break; 
			} 
			} 
		} 
	} 

	/* Utility function to print array arr[] */
	static void printArray(int arr[], int arr_size) 
	{ 
		int i; 
		for (i = 0; i < arr_size; i++) 
			System.out.print(arr[i]+" "); 
		System.out.println(""); 
	} 

	/*Driver function to check for above functions*/
	public static void main (String[] args) 
	{ 
		int arr[] = { 1,3, 1, 3, 3, 2, 3, 1, 2, 2, 3, 1 };
		int arr_size = arr.length; 
		sort012(arr, arr_size); 
		System.out.println("Array after seggregation "); 
		printArray(arr, arr_size); 
	} 
} 
/*This code is contributed by Devesh Agrawal*/
