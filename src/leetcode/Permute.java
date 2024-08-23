package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {
	static List<List<Integer>> ans = new ArrayList<>();

	public static void main(String[] args) {

		String s = "abc";
		System.out.println(permute(new int[] { 6, 2, 1 }));
//		System.out.println(permute(new int[] {1,2,3}));
//		permute(s);
//		permuteUsingRecursion(s, "");
//		permuteSwap(s);
	}

	public static List<List<Integer>> permute(int[] nums) {
		permute(nums, 0);
		return ans;

	}

	private static void permute(int[] nums, int index) {

		int l = nums.length;
		if (index == l - 1) {
			List<Integer> ls = new ArrayList<>(l);
			for (int i = 0; i < l; i++)
				ls.add(nums[i]);

			ans.add(ls);
			// ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

		} else {
			for (int i = index; i < nums.length; i++) {
				swap(nums, index, i);
				permute(nums, index + 1);
				swap(nums, index, i);
			}
		}

	}

	private static void swap(int[] nums, int pos1, int pos2) {
		int t1 = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = t1;
	}

//abc

	private static void permute(String s) {
		int len = s.length();
		int fact = facttorial(len);
		for (int i = 0; i < fact; i++) {
			StringBuilder sb = new StringBuilder(s);
			StringBuilder res = new StringBuilder();
			int index = i;
			for (int divisor = len; divisor >= 1; divisor--) {
				int q = index / divisor;
				int r = index % divisor;
				index = q;
				res.append(sb.charAt(r));
				sb.deleteCharAt(r);
			}
			System.out.print(res.toString());
			System.out.print("	");
		}
	}

	public static List<List<Integer>> leetcode(int[] nums) {
		int len = nums.length;
		int fact = facttorial(len);
		List<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toList());
		List<List<Integer>> res = new ArrayList<>(fact);

		for (int i = 0; i < fact; i++) {
			List<Integer> an = new ArrayList<>(s);
			List<Integer> list = new ArrayList<>(len);
			int index = i;
			for (int divisor = len; divisor >= 1; divisor--) {
				int q = index / divisor;
				int r = index % divisor;
				index = q;
				list.add(an.remove(r));
			}
			res.add(list);
		}
		return res;
	}

	public List<String> find_permutation(String s) {
		int len = s.length();
		int fact = facttorial(len);
		List<String> list = new ArrayList<>(fact);
		for (int i = 0; i < fact; i++) {
			StringBuilder sb = new StringBuilder(s);
			StringBuilder res = new StringBuilder();
			int index = i;
			for (int divisor = len; divisor >= 1; divisor--) {
				int q = index / divisor;
				int r = index % divisor;
				index = q;
				res.append(sb.charAt(r));
				sb.deleteCharAt(r);
			}
			list.add(res.toString());
		}
		Collections.sort(list);

		return list;
	}

	private static int facttorial(int length) {
		int ans = 1;
		for (int i = 2; i <= length; i++) {
			ans *= i;
		}
		return ans;
	}

	private static void permuteUsingRecursion(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < s.length(); i++) {//abcd
			char ch = s.charAt(i);
			String leftPart = s.substring(0, i);
			String rightPart = s.substring(i + 1);
			String remaningString = leftPart + rightPart;
			String ansTill = ans + ch;
			permuteUsingRecursion(remaningString, ansTill);
		}
	}
}
