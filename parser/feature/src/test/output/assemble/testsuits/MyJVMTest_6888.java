import java.beans.ExceptionListener;

public class MyJVMTest_6888 {

    static String exceptionParam1 = "DT}*.H6~!b";

    static String exceptionParam2Param1 = "-!Oo^2J2s6";

    static Throwable exceptionParam2 = new Throwable(exceptionParam2Param1);

    static Exception exception = new Exception(exceptionParam1, exceptionParam2);

    static Object object = -1062791901;

    static String a = "g3Ji19qwH(";

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6888().exceptionThrown(exception);
    }
}
