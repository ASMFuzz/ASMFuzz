public class MyJVMTest_12918 {

    static Object x = -144713520;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12918().pass();
    }
}
