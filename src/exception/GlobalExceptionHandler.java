package exception;

public class GlobalExceptionHandler {
 
    public static void main(String[] args) {
 
        Handler globalExceptionHandler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);
        new GlobalExceptionHandler().performArithmeticOperation(10, 0);
        System.out.println("main end...");
    }
 
    public int performArithmeticOperation(int num1, int num2) {
        return num1/num2;
    }
}
 
class Handler implements Thread.UncaughtExceptionHandler {
 
 
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Unhandled exception caught!");
    }
}