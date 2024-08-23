package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {
		// @formatter:off
		int[][] matrix = { { 1, 2, 3, 4 }, 
						   { 5, 6, 7, 8 }, 
						   { 9, 10, 11, 12 } };
		// @formatter:on
//		System.out.println(spiralOrder(matrix));
		int[][] generateMatrix = generateMatrix(3);
		System.out.println(Arrays.deepToString(generateMatrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();

		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		int size = (right + 1) * (bottom + 1);
		while (list.size() < size) {
			for (int i = left; i <= right && list.size() < size; i++)
				list.add(matrix[top][i]);
			top++;
			for (int i = top; i <= bottom && list.size() < size; i++)
				list.add(matrix[i][right]);
			right--;
			for (int i = right; i >= left && list.size() < size; i--)
				list.add(matrix[bottom][i]);
			bottom--;
			for (int i = bottom; i >= top && list.size() < size; i--)
				list.add(matrix[i][left]);
			left++;
		}
		return list;

	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		int size = matrix[0].length * matrix.length;
		int count = 0;
		while (count < size) {
			for (int i = left; i <= right && count < size; i++)
				matrix[top][i] = ++count;
			top++;
			for (int i = top; i <= bottom && count < size; i++)
				matrix[i][right] = ++count;
			right--;
			for (int i = right; i >= left && count < size; i--)
				matrix[bottom][i] = ++count;
			bottom--;
			for (int i = bottom; i >= top && count < size; i--)
				matrix[i][left] = ++count;
			left++;
		}
		return matrix;
	}
}
