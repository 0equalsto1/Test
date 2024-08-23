package leetcode.intrv;

class FloodFill {
	public static void main(String[] args) {
		//@formatter:off
		int[][] image = {
				   {1, 1, 1, 1, 1, 1, 1, 1},
	               {1, 1, 1, 1, 1, 1, 0, 0},
	               {1, 0, 0, 1, 1, 0, 1, 1},
	               {1, 2, 2, 2, 2, 0, 1, 0},
	               {1, 1, 1, 2, 2, 0, 1, 0},
	               {1, 1, 1, 2, 2, 2, 2, 0},
	               {1, 1, 1, 1, 1, 2, 1, 1},
	               {1, 1, 1, 1, 1, 2, 2, 1},
	               };
		int sr = 4, sc = 4, newColor = 3;
		floodFill(image, sr, sc, newColor);
		//@formatter:on
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++)
				System.out.print(image[i][j] + " ");
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if (color != newColor)
			dfs(image, sr, sc, color, newColor);
		return image;
	}

	public static void dfs(int[][] image, int r, int c, int color, int newColor) {
		if (image[r][c] == color) {
			image[r][c] = newColor;
			if (r >= 1)
				dfs(image, r - 1, c, color, newColor);
			if (c >= 1)
				dfs(image, r, c - 1, color, newColor);
			if (r + 1 < image.length)
				dfs(image, r + 1, c, color, newColor);
			if (c + 1 < image[0].length)
				dfs(image, r, c + 1, color, newColor);
		}
	}
}