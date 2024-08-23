package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ArrayOps {

	public static void main(String[] args) {
		int[][] t = new int[5][];
		System.out.println(1 ^ (1 >>> 16));
		System.out.println(15 & 1);
		int aa[] = new int[] { 3, 6, 3, 9, 3, 6, 5,6,6,6 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < aa.length; i++) {
			map.put(aa[i], map.getOrDefault(aa[i], 0) + 1);
		}
		int max_count = 0, res = -1;
        
        for(Entry<Integer, Integer> val : map.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }
        System.out.println(res);
		t[0] = aa;
		int[][] a = { aa, { 1, 2, 3 }, { 4, 5, 6, 9 }, { 7 } };
//		Arrays.stream(a[0]).forEach(System.out::println);

		int[] arr = new int[] { 100, 80, 70, 60, 50, 0 };
		int val = 65;
		int i = 0;
		for (i = arr.length - 2; i >= 0; i--) {
			if (val > arr[i])
				arr[i + 1] = arr[i];
			else
				break;

		}
		arr[++i] = val;
//		Arrays.stream(arr).forEach(System.out::println);
	}

}
