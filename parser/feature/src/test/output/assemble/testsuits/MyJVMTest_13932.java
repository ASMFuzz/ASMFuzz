public class MyJVMTest_13932 {

    static String xParam1 = "8N4L$Rho65";

    static String xParam2Param1 = "8Wc*r.jSiB";

    static Throwable xParam2 = new Throwable(xParam2Param1);

    static Exception x = new Exception(xParam1, xParam2);

    static Exception thrown = null;

    static boolean goOn = true;

    static long start = -9223372036854775808L;

    static long time = 0;

    Exception fail(Exception x) {
        x.printStackTrace();
        if (thrown == null) {
            thrown = x;
        }
        goOn = false;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13932().fail(x);
    }
}
