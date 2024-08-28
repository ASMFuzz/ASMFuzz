import java.beans.ExceptionListener;

public class MyJVMTest_16398 {

    static String exceptionParam1 = "rY=rMh0M$/";

    static String exceptionParam2Param1 = "rL`~u'VVr4";

    static String exceptionParam2Param2Param1 = "[jK.?^yFO9";

    static String exceptionParam2Param2Param2Param1 = "^[n0UY*s U";

    static Throwable exceptionParam2Param2Param2 = new Throwable(exceptionParam2Param2Param2Param1);

    static boolean exceptionParam2Param2Param3 = false;

    static boolean exceptionParam2Param2Param4 = true;

    static Throwable exceptionParam2Param2 = new Throwable(exceptionParam2Param2Param1, exceptionParam2Param2Param2, exceptionParam2Param2Param3, exceptionParam2Param2Param4);

    static boolean exceptionParam2Param3 = false;

    static boolean exceptionParam2Param4 = false;

    static Throwable exceptionParam2 = new Throwable(exceptionParam2Param1, exceptionParam2Param2, exceptionParam2Param3, exceptionParam2Param4);

    static Exception exception = new Exception(exceptionParam1, exceptionParam2);

    static Object object = 3;

    static String a = "l\"Ps\\^O:UP";

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16398().exceptionThrown(exception);
    }
}
