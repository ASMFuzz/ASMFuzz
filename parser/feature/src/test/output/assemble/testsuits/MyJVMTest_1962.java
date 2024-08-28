public class MyJVMTest_1962 {

    static String xParam1Param1 = "x)(g&_JT(a";

    static Throwable xParam1 = new Throwable(xParam1Param1);

    static Exception x = new Exception(xParam1);

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

    static long start = 0;

    static long time = -6716922103688082578L;

    Exception deadlock(Exception x) {
        deadlock = true;
        System.out.flush();
        fail(x);
        System.err.flush();
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1962().deadlock(x);
    }
}
