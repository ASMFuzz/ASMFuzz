public class MyJVMTest_5874 {

    static int pseudodelay = 0;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5874().pass();
    }
}
