public class MyJVMTest_3583 {

    static Object x = 7;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3583().pass();
    }
}
