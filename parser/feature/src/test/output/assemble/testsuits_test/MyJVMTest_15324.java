public class MyJVMTest_15324 {

    static int pseudodelay = 1;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15324().pass();
    }
}
