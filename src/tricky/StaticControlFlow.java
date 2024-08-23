package tricky;

public class StaticControlFlow {
    static int i = m1();
    int j;
    {
        System.out.println("init block");
    }

    public StaticControlFlow() {
    }

    public StaticControlFlow(int j) {
        this.j = j;
    }

    private static int m1() {
//        System.out.println("i : " + i);
//        System.out.println("hello...");
        return 10;
    }

    public static void main(String[] args) {
        System.out.println(new StaticControlFlow());
        System.out.println(new StaticControlFlow(11));
    }
}
