package leetcode.intrv;

public class MaxSubArrSum {
    static int maxSum = Integer.MIN_VALUE;

    //	public static void main(String[] args) {
    static public void main(String[] args) {

//		int[] a = { -1, 2, 4, -3, 5, 7, -5, 6 };
//		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        int[] a = {-2, -3, -1, -2, -3};

        printSubSet1(a);
        printSubSet2(a);
        printSubSet3(a);
    }

    private static void printSubSet1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
//					System.out.print("[" + arr[k] + "]");
//					System.out.print(",");
                    sum += arr[k];

                }
                maxSum = maxSum > sum ? maxSum : sum;
//				System.out.print(sum);
//				System.out.print(",");
            }
        }
        System.out.println(maxSum);
    }

    private static void printSubSet2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = maxSum > sum ? maxSum : sum;
            }
        }
        System.out.println(maxSum);
    }

    //		int[] a = { -2, -3, -1, -2, -3 };
    private static void printSubSet3(int[] a) {
        int size = a.length;
        int max = a[0], sum = a[0];

        for (int i = 1; i < size; i++) {
            sum = sum + a[i];
            if (a[i] > sum)
                sum = a[i];
            if (sum > max)
                max = sum;

        }
        System.out.println("max = " + max);
    }

}
