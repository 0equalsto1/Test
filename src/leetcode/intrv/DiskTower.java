package leetcode.intrv;

import java.io.*;
import java.util.*;

class DiskTower {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_arr = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
			arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
		}

		ArrayList<Integer>[] out_ = Solve(arr);
		for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

			for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
				System.out.print(out_[i_out_].get(j_out_) + " ");
			}
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] Solve(int[] arr) {
		int max;
		int l = max = arr.length;

		int[] disk = new int[l + 1];
		ArrayList<Integer>[] list = new ArrayList[l];
		for (int i = 0; i < l; i++) {
			ArrayList<Integer> d = new ArrayList<>();
			disk[arr[i]] = 1;
			if (arr[i] == max) {
				d.add(max);
				max--;
				while (disk[max] == 1) {
					d.add(max);
					max--;
				}
			}
			list[i] = d;
		}
		return list;
	}
}