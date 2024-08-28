public class MyJVMTest_4459 {

    static int a = 0;

    static int b = 4;

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
        new MyJVMTest_4459().test();
    }
}
