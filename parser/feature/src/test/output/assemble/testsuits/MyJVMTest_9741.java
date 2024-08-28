public class MyJVMTest_9741 {

    static int a = 6;

    static int b = 0;

    int f2(int a, int b) {
        if (a == b)
            ;
        System.out.println("a == b");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9741().f2(a, b);
    }
}
