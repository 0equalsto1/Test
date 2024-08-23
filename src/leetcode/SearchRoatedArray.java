package leetcode;

public class SearchRoatedArray {
	public int search(int[] a, int t) {
		int left = 0, right = a.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == t)
				return mid;
			if (a[left] <= a[mid]) {
				if (t >= a[left] && t < a[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (t > a[mid] && t <= a[right])
					left = mid + 1;
				else
					right = mid - 1;
			}

		}
		return -1;
	}
}
