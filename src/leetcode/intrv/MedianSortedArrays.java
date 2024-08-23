package leetcode.intrv;

public class MedianSortedArrays {

	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		if (l1 == 0 && l2 == 0)
			return 0;
		if (l1 == 0) {
			int m = l2 / 2;
			return (l2 % 2 == 0) ? (nums2[m] + nums2[m - 1]) / 2.0 : nums2[m];
		}
		if (l2 == 0) {
			int m = l1 / 2;
			return (l1 % 2 == 0) ? (nums1[m] + nums1[m - 1]) / 2.0 : nums1[m];
		}
		int m = (l1 + l2 + 1) / 2;
		boolean isEven = (l1 + l2) % 2 == 0;
		int i = 0;
		int j = 0;
		int m1 = 0, m2 = 0;
		int k = 0;
		for (; k < m; k++) {
			if (i < l1 && j < l2) {
				int ni = nums1[i];
				int nj = nums2[j];
				if (ni < nj) {
					m1 = ni;
					m2 = nj;
					i++;
				} else {
					m1 = nj;
					m2 = ni;
					j++;
				}
			} else if (i >= l1) {
				m1 = nums2[j];
				m2 = nums2[j + 1];
				j++;
			} else {
				m1 = nums1[i];
				m2 = nums1[i + 1];
				i++;
			}
		}
		if (i < l1 && j < l2)
			m2 = Math.min(nums1[i], nums2[j]);
		return isEven ? (m1 + m2) / 2.0 : m1;
	}

	public static void main(String[] args) {
		/*int[] nums1 = new int[] { 1, 2, 3, 4, 10 };// [1,2,3,4,5,6,7,8,9,10]
		int[] nums2 = new int[] { 5, 6, 7, 8, 9 };
		*/
		/*int[] nums1 = new int[] { 1, 2, 3, 4 };//1,2,3,4,5,6,7,8
		int[] nums2 = new int[] { 5, 6, 7, 8 };*/

		/*int[] nums1 = new int[] { 1, 3, 5, 7 };
		int[] nums2 = new int[] { 2, 4, 6, 8,9 };*/
//-1,1,2,3
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { -1, 3 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
