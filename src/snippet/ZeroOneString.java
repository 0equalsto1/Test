package snippet;
public class ZeroOneString {
	public static void main(String[] args) {
		int[] arr = new int[] { 0,0,0,1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1 };
		int _0index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
				arr[_0index++] = 0;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}