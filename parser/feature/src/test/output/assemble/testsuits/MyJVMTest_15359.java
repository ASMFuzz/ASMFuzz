public class MyJVMTest_15359 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 1427439867;

    static long quittingTime = 5933330438676192946L;

    static int i = 0;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15359().pass();
    }
}
