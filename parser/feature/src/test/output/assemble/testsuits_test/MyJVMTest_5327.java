public class MyJVMTest_5327 {

    static String tParam1Param1 = "_R%vlIvcmQ";

    static String tParam1Param2Param1Param1 = "FU.S3^<]j`";

    static String tParam1Param2Param1Param2Param1Param1 = "~}r}g,I4kP";

    static String tParam1Param2Param1Param2Param1Param2Param1Param1 = "pJ+eMX^:4q";

    static Throwable tParam1Param2Param1Param2Param1Param2Param1 = new Throwable(tParam1Param2Param1Param2Param1Param2Param1Param1);

    static Throwable tParam1Param2Param1Param2Param1Param2 = new Throwable(tParam1Param2Param1Param2Param1Param2Param1);

    static boolean tParam1Param2Param1Param2Param1Param3 = true;

    static boolean tParam1Param2Param1Param2Param1Param4 = true;

    static Throwable tParam1Param2Param1Param2Param1 = new Throwable(tParam1Param2Param1Param2Param1Param1, tParam1Param2Param1Param2Param1Param2, tParam1Param2Param1Param2Param1Param3, tParam1Param2Param1Param2Param1Param4);

    static Throwable tParam1Param2Param1Param2 = new Throwable(tParam1Param2Param1Param2Param1);

    static Throwable tParam1Param2Param1 = new Throwable(tParam1Param2Param1Param1, tParam1Param2Param1Param2);

    static Throwable tParam1Param2 = new Throwable(tParam1Param2Param1);

    static boolean tParam1Param3 = false;

    static boolean tParam1Param4 = false;

    static Throwable tParam1 = new Throwable(tParam1Param1, tParam1Param2, tParam1Param3, tParam1Param4);

    static Throwable t = new Throwable(tParam1);

    Throwable throwThrowable(Throwable t) throws Exception {
        if (t instanceof Error)
            throw (Error) t;
        if (t instanceof RuntimeException)
            throw (RuntimeException) t;
        throw (Exception) t;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5327().throwThrowable(t);
    }
}
