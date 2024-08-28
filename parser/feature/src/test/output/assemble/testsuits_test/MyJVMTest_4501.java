import java.lang.reflect.*;

public class MyJVMTest_4501 {

    static String expected = "^kA$&[Y+\\o";

    static String actual = "i*t/bNL9CZ";

    static String eParam1 = "NPP2YBP#e$";

    static String eParam2Param1 = "SYl' !mM14";

    static String eParam2Param2Param1Param1Param1 = "eKLe!G&N-a";

    static Throwable eParam2Param2Param1Param1 = new Throwable(eParam2Param2Param1Param1Param1);

    static Throwable eParam2Param2Param1 = new Throwable(eParam2Param2Param1Param1);

    static Throwable eParam2Param2 = new Throwable(eParam2Param2Param1);

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2);

    static boolean eParam3 = true;

    static boolean eParam4 = false;

    static Exception e = new Exception(eParam1, eParam2, eParam3, eParam4);

    String assertCorrect(String expected, String actual, Exception e) throws Exception {
        if (!expected.equals(actual)) {
            throw new IllegalStateException("Expected: " + expected + "; Actual: " + actual, e);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4501().assertCorrect(expected, actual, e);
    }
}
