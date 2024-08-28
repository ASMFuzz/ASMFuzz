public class MyJVMTest_5908 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 2089211497;

    static long quittingTime = 0;

    static int i = 0;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5908().pass();
    }
}
