package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {

		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] grid2 = { { 2, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		System.out.println(orangesRotting2(grid));
		System.out.println(orangesRotting2(grid2));
//		System.out.println(orangesRotting(grid));
//		System.out.println(orangesRotting(grid2));

	}

	public static int orangesRotting(int[][] grid) {
		Deque<Integer> rotten = new ArrayDeque<>();
		int r = grid.length, c = grid[0].length, fresh = 0, time = -1;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (grid[i][j] == 2)
					rotten.add(i * c + j);
				else if (grid[i][j] == 1)
					fresh++;
			}
		}
		if (fresh == 0)
			return 0;
		while (!rotten.isEmpty()) {
			time++;
			int num = rotten.size();
			for (int indx = 0; indx < num; ++indx) {
				int tamo = rotten.poll();
				int i = tamo / c, j = tamo % c;
				if (i > 0 && grid[i - 1][j] == 1) {// UP
					grid[i - 1][j] = 2;
					fresh--;
					rotten.add((i - 1) * c + j);
				}
				if (i < r - 1 && grid[i + 1][j] == 1) {// DOWN
					grid[i + 1][j] = 2;
					fresh--;
					rotten.add(((i + 1) * c) + j);
				}
				if (j > 0 && grid[i][j - 1] == 1) {// LEFT
					grid[i][j - 1] = 2;
					fresh--;
					rotten.add((i * c) + (j - 1));
				}
				if (j < c - 1 && grid[i][j + 1] == 1) {// RIGHT
					grid[i][j + 1] = 2;
					fresh--;
					rotten.add((i * c) + (j + 1));
				}

			}
		}
		return (fresh == 0) ? time : -1;
	}

	public static int orangesRotting2(int[][] grid) {
		Queue<int[]> rotten = new LinkedList<int[]>();
		int r = grid.length, c = grid[0].length, fresh = 0, time = -1;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (grid[i][j] == 2)
					rotten.add(new int[] { i, j });
				else if (grid[i][j] == 1)
					fresh++;
			}
		}
		if (fresh == 0)
			return 0;
		while (!rotten.isEmpty()) {
			time++;
			int num = rotten.size();
			for (int indx = 0; indx < num; ++indx) {
				int[] tamo = rotten.remove();
				int i = tamo[0], j = tamo[1];
				if (i > 0 && grid[i - 1][j] == 1) {// UP
					grid[i - 1][j] = 2;
					fresh--;
					rotten.add(new int[] { i - 1, j });
				}
				if (i < r - 1 && grid[i + 1][j] == 1) {// DOWN
					grid[i + 1][j] = 2;
					fresh--;
					rotten.add(new int[] { i + 1, j });
				}
				if (j > 0 && grid[i][j - 1] == 1) {// LEFT
					grid[i][j - 1] = 2;
					fresh--;
					rotten.add(new int[] { i, j - 1 });
				}
				if (j < c - 1 && grid[i][j + 1] == 1) {// RIGHT
					grid[i][j + 1] = 2;
					fresh--;
					rotten.add(new int[] { i, j + 1 });
				}

			}
		}
		return (fresh == 0) ? time : -1;
	}

}
