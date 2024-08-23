package snippet;

public class MinNoOfDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public static int mindays2(int n, int gDays, int bDays) {
		int ans = 0;
		int min = n / 2;
		if (n <= gDays)
			return n;
		while (n > 0) {
			ans += gDays;
			min = min - gDays;
			n = n - gDays;
			int t = gDays + bDays;
			if (gDays >= bDays) {
				int gf = n / gDays;
				int bf = n / bDays;
			}
		}
		return ans;
	}
}
