public class MyJVMTest_15892 {

    static Thread expectedThread = null;

    static long from = 2958704955081936039L;

    static long to = -9223372036854775808L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15892().pass();
    }
}
