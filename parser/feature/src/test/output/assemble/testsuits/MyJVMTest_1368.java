public class MyJVMTest_1368 {

    static String xParam1 = "n.;ZE<f75*";

    static String xParam2Param1 = "Uh1v iM)Bs";

    static Throwable xParam2 = new Throwable(xParam2Param1);

    static Exception x = new Exception(xParam1, xParam2);

    static Exception thrown = null;

    static boolean goOn = true;

    static long start = 9223372036854775807L;

    static long time = 9223372036854775807L;

    Exception fail(Exception x) {
        x.printStackTrace(System.err);
        if (thrown == null) {
            thrown = x;
        }
        goOn = false;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1368().fail(x);
    }
}
