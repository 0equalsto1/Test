package leetcode;

public class TwoSortedArrays {
	public static void main(String[] args) {
		int n = 7, m = 11, k = 15;
		int nums1[] = { 2, 3, 6, 7, 9 };
		int nums2[] = { 1, 4, 8, 10 };
//		double medianOfSortedArrays = medianOfSortedArrays(nums1, nums2);
//		System.out.println("medianOfSortedArrays : " + medianOfSortedArrays);
//		kthElement(arr1, arr2, n, m, k);
		int kthElement = kthElement(nums1, nums2, 5);
		System.out.println(kthElement);
	}

	public static double medianOfSortedArrays(int[] nums1, int[] nums2) {

		int n1 = nums1.length;
		int n2 = nums2.length;
		int l = (n1 + n2) / 2;
		int i = 0, j = 0;
		int prev = 0;
		int cur = 0;
		while (l-- >= 0) {
			prev = cur;
			if (i != n1 && j != n2)
				cur = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
			else if (i < n1)
				cur = nums1[i++];
			else
				cur = nums2[j++];
		}
		return (n1 + n2) % 2 == 1 ? cur : (cur + prev) / 2.0;

	}

	public double medianSortedArrays(int[] nums1, int[] nums2) {
		if (nums2.length < nums1.length)
			return medianSortedArrays(nums2, nums1);
		int n1 = nums1.length;
		int n2 = nums2.length;

		int low = 0;//low 0 means no elements from nums1 to make left1
		int high = n1;//high n means all elements from nums1 to make left1

		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = (n1 + n2 + 1) / 2 - cut1;

			int left1 = (cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]);
			int left2 = (cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1]);

			int right1 = (cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1]);
			int right2 = (cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2]);

			if (left1 <= right2 && left2 <= right1) {
				if ((n1 + n2) % 2 == 0)
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				else
					return Math.max(left1, left2);
			}
			if (left1 > right2)
				high = cut1 - 1;
			else
				low = cut1 + 1;
		}
		return 0.0;
	}

	public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
		if (n > m) {
			return kthElement(arr2, arr1, m, n, k);
		}

		int low = Math.max(0, k - m);// low always not be 0 'coz may be k > m,so we have to take some elements from
										// arr1
		int high = Math.min(k, n);// high always not be n 'coz may be n > k ,so index-outof-bond

		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = k - cut1;
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
			int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
			int r2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];

			if (l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);
			} else if (l1 > r2) {
				high = cut1 - 1;
			} else {
				low = cut1 + 1;
			}
		}
		return 1;
	}

	public static int kthElement(int[] nums1, int[] nums2, int k) {

		int n1 = nums1.length;
		int n2 = nums2.length;
		int i = 0, j = 0;
		int cur = 0;
		while (k-- > 0) {
			if (i != n1 && j != n2)
				cur = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
			else if (i < n1)
				cur = nums1[i++];
			else
				cur = nums2[j++];
		}
		return cur;

	}

}
