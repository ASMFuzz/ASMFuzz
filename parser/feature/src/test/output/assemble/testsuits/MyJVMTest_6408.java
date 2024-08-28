public class MyJVMTest_6408 {

    static Thread expectedThread = null;

    static long from = 9223372036854775807L;

    static long to = 9223372036854775807L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6408().pass();
    }
}
