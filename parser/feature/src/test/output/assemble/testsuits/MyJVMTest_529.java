public class MyJVMTest_529 {

    static Long v = 1L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_529().pass();
    }
}
