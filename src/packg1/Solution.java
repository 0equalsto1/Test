package packg1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("boxing")
public class Solution {
	static int arr[][];
	static List<Integer> list = null;

	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner scan = new Scanner(System.in);
		int large = 0;
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		list = new ArrayList<>(m * n);
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input[] = scan.nextLine().split(" ");
			for (int j = 0; j < input.length; j++) {

				if ((Integer.parseInt(input[j])) == 1)
					list.add(large);
				large++;
			}
		}
		System.out.println(list);
		int max = 0;
		for (Integer i : list) {
			large = 1;
			for (int j = 1; j < list.size();j++) {
				if (list.contains(i + 1))
					large++;
				if (list.contains(i + m))
					large++;
				if (list.contains(i + m + 1))
					large++;
				
				i = list.get(j = large);
			}
			if (large > max)
				max = large;
		}
		System.out.println(max);
	}

}