package array;

public class TransposeMatrix {
	static final int N = 4;

	public static void main(String[] args) {
		// @formatter:off
		int A[][] = { 
				{1, 1, 1, 1}, 
                {2, 2, 2, 2}, 
                {3, 3, 3, 3}, 
                {4, 4, 4, 4}
                
		       };
		// @formatter:on
		int[][] B = transpose(A);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(B[i][j] + " ");
			System.out.print("\n");
		}
	}

	static int[][] transpose(int A[][]) {
		int B[][] = new int[N][N];
		int i, j;
		for (i = 0; i < N; i++)
			for (j = 0; j < N; j++)
				B[i][j] = A[j][i];
		return B;
	}

}
