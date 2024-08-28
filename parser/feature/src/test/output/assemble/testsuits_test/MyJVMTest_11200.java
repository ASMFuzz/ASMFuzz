public class MyJVMTest_11200 {

    static Exception x = new Exception();

    void fail(Exception x) {
        x.printStackTrace(System.err);
        if (thrown == null) {
            thrown = x;
        }
        goOn = false;
    }

    static Exception thrown = null;

    static boolean goOn = true;

    static boolean deadlock = false;

    static long start = -9223372036854775808L;

    static long time = 9223372036854775807L;

    Exception deadlock(Exception x) {
        deadlock = true;
        System.out.flush();
        fail(x);
        System.err.flush();
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11200().deadlock(x);
    }
}
