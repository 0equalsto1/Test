package codility;

public class InterestingPolygon {

	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(2+3+4+5+6+7+8);
	}

	static int optimalSolution(int n) {
		return (n * n) + (n - 1) * (n - 1);

	}

	static int solution(int n) {

		int ans = n * 2 - 1;
		int incr = 1;
		for (int i = 1; i < n; i++) {
			ans += incr * 2;
			incr += 2;
		}
		return ans;
	}
}
