public class MyJVMTest_13844 {

    static int a = 4;

    static int b = 5;

    void test() {
        int tt = b;
        while (a == 0) {
        }
        if (b == 0) {
            System.err.println("wrong value of b");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13844().test();
    }
}
