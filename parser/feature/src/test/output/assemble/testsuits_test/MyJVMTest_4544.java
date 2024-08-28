public class MyJVMTest_4544 {

    static String xParam1 = "PHjXXS<u_r";

    static String xParam2Param1 = "YlsbSZNje*";

    static String xParam2Param2Param1 = "sKC[f\"M`v ";

    static Throwable xParam2Param2Param2 = new Throwable();

    static Throwable xParam2Param2 = new Throwable(xParam2Param2Param1, xParam2Param2Param2);

    static Throwable xParam2 = new Throwable(xParam2Param1, xParam2Param2);

    static boolean xParam3 = false;

    static boolean xParam4 = false;

    static Exception x = new Exception(xParam1, xParam2, xParam3, xParam4);

    static Exception thrown = null;

    static boolean goOn = true;

    static long start = 5434805760438466233L;

    static long time = 9223372036854775807L;

    Exception fail(Exception x) {
        x.printStackTrace();
        if (thrown == null) {
            thrown = x;
        }
        goOn = false;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4544().fail(x);
    }
}
