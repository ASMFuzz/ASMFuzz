import java.beans.XMLDecoder;

public class MyJVMTest_16489 {

    static String exceptionParam1 = "-M9)/^M9Mo";

    static String exceptionParam2Param1 = "qQ~%5\\uk,I";

    static String exceptionParam2Param2Param1 = "6Ez&%%[Au!";

    static String exceptionParam2Param2Param2Param1 = "[J?ZhFVILa";

    static String exceptionParam2Param2Param2Param2Param1 = "PJ'-.:H3w,";

    static String exceptionParam2Param2Param2Param2Param2Param1 = "~{)m#1tL:}";

    static Throwable exceptionParam2Param2Param2Param2Param2 = new Throwable(exceptionParam2Param2Param2Param2Param2Param1);

    static Throwable exceptionParam2Param2Param2Param2 = new Throwable(exceptionParam2Param2Param2Param2Param1, exceptionParam2Param2Param2Param2Param2);

    static Throwable exceptionParam2Param2Param2 = new Throwable(exceptionParam2Param2Param2Param1, exceptionParam2Param2Param2Param2);

    static Throwable exceptionParam2Param2 = new Throwable(exceptionParam2Param2Param1, exceptionParam2Param2Param2);

    static Throwable exceptionParam2 = new Throwable(exceptionParam2Param1, exceptionParam2Param2);

    static boolean exceptionParam3 = false;

    static boolean exceptionParam4 = false;

    static Exception exception = new Exception(exceptionParam1, exceptionParam2, exceptionParam3, exceptionParam4);

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16489().exceptionThrown(exception);
    }
}
