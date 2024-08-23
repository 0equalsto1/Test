package recursion;

public class NumberPrinter {
    public static void printNumbers(int n) {
        if (n > 1) {
            printNumbers(n - 1);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10;
        printNumbers(n);
    }

    public static void printNumbers2(int n) {
        if (n == 0)
            return;
        printNumbers2(n - 1);
        System.out.println(n);
    }

}