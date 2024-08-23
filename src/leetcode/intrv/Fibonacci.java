package leetcode.intrv;
public class Fibonacci{
	public static int fibDP(int x) {
			int fib[] = new int[x + 1];
			fib[0] = 0;
			fib[1] = 1;
			for (int i = 2; i <=x; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
				System.out.println(fib[i]);
			}
			System.out.println("====================");
		return fib[x];
		}
	public static void main(String[] args){
		System.out.println(fibDP(5));
	}
}