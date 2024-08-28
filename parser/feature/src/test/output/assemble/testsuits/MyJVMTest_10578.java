public class MyJVMTest_10578 {

    static Throwable xParam1 = new Throwable();

    static Exception x = new Exception(xParam1);

    static Exception thrown = null;

    static boolean goOn = true;

    static long start = -9223372036854775808L;

    static long time = -4072491178696650223L;

    Exception fail(Exception x) {
        x.printStackTrace(System.err);
        if (thrown == null) {
            thrown = x;
        }
        goOn = false;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10578().fail(x);
    }
}
