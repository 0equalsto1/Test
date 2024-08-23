package leetcode.intrv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2_3_4_Sum {

    public static void main(String[] args) {
        int target = 0;
        int[] nums = {12, -8, 5, 1, -7, -6, 2, 3, 6, 4};
        printAllThreeSum(nums, target);

    }

    public int[] two_Sum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaning = target - nums[i];
            if (numMap.containsKey(remaning))
                return new int[]{numMap.get(remaning), i};
            else
                numMap.put(nums[i], i);
        }
        return new int[]{};

    }

    //duplicate not handeld
    public static void printAllThreeSum(int[] array, int target) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int first = array[i];
            Map<Integer, Integer> map = new HashMap<>();
            int newTarget = target - first;
            for (int j = i + 1; j < length; j++) {
                int key = newTarget - array[j];
                if (map.containsKey(key))
                    System.out.println(first + " , " + array[j] + " , " + array[map.get(key)]);
                else
                    map.put(array[j], j);

            }

        }

    }

    public static List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

                int lo = i + 1, hi = num.length - 1, sum = -num[i];

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {

                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;

                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;

                    else
                        hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (num == null || num.length == 0)
            return res;

        int n = num.length;

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {

            int target_3 = target - num[i];

            for (int j = i + 1; j < n; j++) {

                int target_2 = target_3 - num[j];

                int front = j + 1;
                int back = n - 1;

                while (front < back) {

                    int two_sum = num[front] + num[back];

                    if (two_sum < target_2)
                        front++;

                    else if (two_sum > target_2)
                        back--;

                    else {

                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);

                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2))
                            ++front;

                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3))
                            --back;

                    }
                }

                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j])
                    ++j;
            }

            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i])
                ++i;

        }

        return res;
    }
}
