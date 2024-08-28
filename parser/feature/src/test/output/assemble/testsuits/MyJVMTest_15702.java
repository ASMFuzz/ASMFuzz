public class MyJVMTest_15702 {

    static int a = 0;

    static int b = 7;

    int f1(int a, int b) {
        if (a == b)
            ;
        System.out.println("a == b");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15702().f1(a, b);
    }
}
