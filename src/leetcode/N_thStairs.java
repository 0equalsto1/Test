package leetcode;

import java.util.HashMap;
import java.util.Map;

public class N_thStairs {
	static Map<Integer, Integer> dp = null;

	public static void main(String[] args) {

		System.out.println(climbStairs(65));
		System.out.println(countDistinctWayToClimbStair(65));
	}

	public static int climbStairs(int n) {
		dp = new HashMap<>();
		return countDistinctWayToClimbStair2(0, n);
		// return climbStairs2(n);

	}

	public static int countDistinctWayToClimbStair2(int n, long stairs) {
		if (n == stairs)
			return 1;
		if (n > stairs)
			return 0;
		if (dp.containsKey(n))
			return dp.get(n);

		int steps = countDistinctWayToClimbStair2(n + 1, stairs) + countDistinctWayToClimbStair2(n + 2, stairs);
		dp.put(n, steps);
		return steps;
	}

	public static int countDistinctWayToClimbStair(long n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int oneStepBefore = 2;
		int twoStepsBefore = 1;
		int total = 0;

		for (int i = 2; i < n; i++) {
			total = oneStepBefore + twoStepsBefore;
			twoStepsBefore = oneStepBefore;
			oneStepBefore = total;
		}
		return total;
	}

}
