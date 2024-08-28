public class MyJVMTest_1435 {

    static String tParam1 = "q97l9WB.|R";

    static String tParam2Param1 = "$2|r%=OCJ)";

    static String tParam2Param2Param1 = "ADh{8m\\CN'";

    static Throwable tParam2Param2 = new Throwable(tParam2Param2Param1);

    static Throwable tParam2 = new Throwable(tParam2Param1, tParam2Param2);

    static Throwable t = new Throwable(tParam1, tParam2);

    static String eParam1 = "QfEnvTs@Q!";

    static String eParam2 = "0c4xMC4)'6";

    static String eParam3 = "c8 .7T|0@g";

    static int eParam4 = 282;

    static StackTraceElement e = new StackTraceElement(eParam1, eParam2, eParam3, eParam4);

    static String methodName = "XOb4$WJ\"Z\"";

    static int n = 0;

    static String OUR_CLASS = ChainedExceptions.class.getName();

    static String OUR_FILE_NAME = "ChainedExceptions.java";

    StackTraceElement check(Throwable t, StackTraceElement e, String methodName, int n) {
        if (!e.getClassName().equals(OUR_CLASS))
            throw new RuntimeException("Class: " + e, t);
        if (!e.getMethodName().equals(methodName))
            throw new RuntimeException("Method name: " + e, t);
        if (!e.getFileName().equals(OUR_FILE_NAME))
            throw new RuntimeException("File name: " + e, t);
        if (e.getLineNumber() != n)
            throw new RuntimeException("Line number: " + e, t);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1435().check(t, e, methodName, n);
    }
}
