public class MyJVMTest_10648 {

    static Throwable t = new Throwable();

    static String eParam1 = "e1iWCaX{`W";

    static String eParam2 = "5}Q)@^Uf'O";

    static String eParam3 = "CH^<m/Gqq5";

    static int eParam4 = 346;

    static StackTraceElement e = new StackTraceElement(eParam1, eParam2, eParam3, eParam4);

    static String methodName = "rj!ge>okH:";

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
        new MyJVMTest_10648().check(t, e, methodName, n);
    }
}
