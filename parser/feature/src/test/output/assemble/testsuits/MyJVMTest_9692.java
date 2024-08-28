public class MyJVMTest_9692 {

    static Long v = 1L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9692().pass();
    }
}
