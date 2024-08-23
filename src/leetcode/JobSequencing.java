package leetcode;

import java.util.Arrays;

public class JobSequencing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> b.profit - a.profit);
		int job = 0, profit = 0, maxDeadline = 0;
		for (Job j : arr) {
			if (j.deadline >= maxDeadline)
				maxDeadline = j.deadline;
		}
		int[] md = new int[maxDeadline + 1];
		for (int i = 0; i < n; i++) {
			int ded = arr[i].deadline;

			for (int j = ded; j > 0; j--) {
				if (md[j] == 0) {
					job++;
					profit += arr[i].profit;
					md[j] = i+1;
					break;
				}
			}
		}
		return new int[] { job, profit };
	}
}

class Job {
	int id, profit, deadline;

	Job(int x, int y, int z) {
		this.id = x;
		this.deadline = y;
		this.profit = z;
	}
}