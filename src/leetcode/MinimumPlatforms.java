package leetcode;

import java.util.Arrays;

public class MinimumPlatforms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int calculateMinPatforms(int at[], int dt[], int n) {
		int ans = 1;
		int pl = 1;
		Arrays.sort(at);
		Arrays.sort(dt);
		int i = 1, j = 0;
		while (i < n && j < n) {
			if (at[i] <= dt[j]) {
				pl++;
				i++;
			} else {
				j++;
				pl--;
			}
			ans = ans > pl ? ans : pl;
		}
		return ans;

	}
}
