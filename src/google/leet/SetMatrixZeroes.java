package google.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an m x n integer matrix matrix, if an element is 0, 
//set its entire row and column to 0's, and return the matrix.
public class SetMatrixZeroes {

	public static void main(String[] args) {
		int i = '_';
		System.out.println(i);

		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
		/*int[][] matrix2 = new int[][]{{1},{0}};
		setZeroes(matrix2);
		System.out.println(Arrays.deepToString(matrix2));*/
	}

	// if all array element >= 0
	public static void setZeroes2(int[][] matrix) {
		int rw = matrix.length;
		int col = matrix[0].length;
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < rw; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {

					for (int k = 0; k < col || k < rw; k++) {
						if (k < col && matrix[i][k] != 0) {
							matrix[i][k] = min;
						}
						if (k < rw && matrix[k][j] != 0) {
							matrix[k][j] = min;
						}
					}
				}
			}
		}
		for (int i = 0; i < rw; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == min) {
					matrix[i][j] = 0;
				}
			}
		}
		// Traverse column wise
		/*	for (int j = 0; j < col; j++) {
				for (int i = 0; i < rw; i++) {
					if (matrix[i][j] == 0) {
						// Set all the elements that are not zero as -1
						for (int k = 0; k < rw; k++) {
							if (matrix[k][j] != 0) {
								matrix[k][j] = -1;
							}
						}
					}
				}
			}*/

		// Update all -1 as 0

	}

//	int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

	public static void setZeroes(int[][] matrix) {
		Set<Integer> row = new HashSet<>(matrix.length, 1.0f);
		Set<Integer> col = new HashSet<>(matrix[0].length, 1.0f);
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (int r : row) {
			for (int j = 0; j < n; j++) {
				matrix[r][j] = 0;
			}
		}

		for (int c : col) {
			for (int i = 0; i < m; i++) {
				matrix[i][c] = 0;
			}
		}
	}
}
