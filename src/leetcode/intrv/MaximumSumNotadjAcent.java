package leetcode.intrv;

public class MaximumSumNotadjAcent {

	public static void main(String[] args) {
//		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		int arr[] = new int[] {1, 9, 1, 10, 1, 9, 1};
		System.out.println(findMaxSum(arr));
	}

	private static int findMaxSum(int[] arr) {
		int ev = 0;
		int od = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((i & 1) != 1)
				ev += arr[i];
			else
				od += arr[i];
		}
		return ev > od ? ev : od;
	}

}
