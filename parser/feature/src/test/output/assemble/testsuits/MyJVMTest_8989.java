public class MyJVMTest_8989 {

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8989().pass();
    }
}
