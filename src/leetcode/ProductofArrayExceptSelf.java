package leetcode;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }

        return ans;
    }


    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    public static Stream<Arguments> arryInput() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 2, 3, 4}));
    }

     @ParameterizedTest
     @MethodSource("arryInput")
    public int[] productExceptSelf4(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
