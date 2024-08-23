package leetcode.intrv;

public class ThrottlingGateway {

	public static void main(String[] args) {
		int[] requestTime = new int[] {1, 1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7};
		System.out.println(solution(requestTime));
	}

	public static int droppedRequests(int[] requestTime) {
		int td = 0;

		return td;
	}

	public static int solution(int[] requestTime) {
		int n = requestTime.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i > 2 && requestTime[i] - requestTime[i - 3] < 1) {
				++count;
			} else if (i >19 && requestTime[i] - requestTime[i - 20] < 10) {
				++count;
			} else if (i > 59 && requestTime[i] - requestTime[i - 60] < 60) {
				++count;
			}
		}
		return count;
	}
}
