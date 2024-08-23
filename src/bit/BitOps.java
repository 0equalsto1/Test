package bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitOps {

	public static void main(String[] args) {
		System.out.println((9 - 1) >>> 1);
		int[] arr = { 1, 3, 7, 7, 3, 6, 6 };
//		System.out.println(findUnique1(arr));
//		System.out.println(findUnique2(arr));
//		List<Integer> asList = Arrays.asList(1,2,3,3,4,5,6);//1,2,4,5,6
//		System.out.println(findDuplicate2(Arrays.asList(4, 2, 1, 3, 1)));
//		System.out.println(findDuplicate2(asList));
//		System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
	}

	public static int findUnique2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>(arr.length, 1.0f);
		for (int i : arr) {
			if (map.containsKey(i))
				map.remove(i);
			else
				map.put(i, i);

		}
		return map.keySet().iterator().next();
	}

	public static int findUnique1(int[] arr) {
		int ans = arr[0];
		for (int i = 1; i < arr.length; i++) {
			ans ^= arr[i];
		}
		return ans;
	}/*
		You are given an array ‘ARR’ of size ‘N’ containing each 
		number between 1 and ‘N’ - 1 at least once. 
		There is a single integer value that is present in 
		the array twice. Your task is to find the duplicate integer 
		value present in the array.
		*/

	public static int findDuplicate(List<Integer> arr) {

		int ans = arr.get(0);
		int size = arr.size();
		for (int i = 1; i < size; i++)
			ans = ans ^ arr.get(i);
		for (int i = 1; i < size; i++)
			ans = ans ^ i;
		return ans;
	}
	public static int findDuplicate2(List<Integer> arr) {
		int n = arr.size();
		int ans = n * (n + 1) / 2;
		int sum = arr.get(0);
		for (int i = 1; i < n; i++)
			sum = sum + arr.get(i);
		return n-(ans-sum);
	}
//	Input: nums = [4,3,2,7,8,2,3,1]
//	Output: [2,3]
	public static List<Integer> findDuplicates(int[] nums) {
	    List<Integer> ans = new ArrayList<>();   
	    for(int n:nums){
	        int i = (n < 0) ? -n : n;
	        if(nums[i-1]<0)
	            ans.add(i);
	        else
	            nums[i-1] *= -1;
	    }
	    return ans;
	}
}
