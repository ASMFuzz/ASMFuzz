import java.lang.reflect.*;

public class MyJVMTest_13888 {

    static String expected = "~1Y*&WuIVE";

    static String actual = "gI`W]\\ar=q";

    static String eParam1Param1Param1 = "/\"&cHXpIKs";

    static String eParam1Param1Param2Param1Param1Param1 = "@n*zXPB;y+";

    static Throwable eParam1Param1Param2Param1Param1Param2 = new Throwable();

    static Throwable eParam1Param1Param2Param1Param1 = new Throwable(eParam1Param1Param2Param1Param1Param1, eParam1Param1Param2Param1Param1Param2);

    static Throwable eParam1Param1Param2Param1 = new Throwable(eParam1Param1Param2Param1Param1);

    static Throwable eParam1Param1Param2 = new Throwable(eParam1Param1Param2Param1);

    static boolean eParam1Param1Param3 = true;

    static boolean eParam1Param1Param4 = true;

    static Throwable eParam1Param1 = new Throwable(eParam1Param1Param1, eParam1Param1Param2, eParam1Param1Param3, eParam1Param1Param4);

    static Throwable eParam1 = new Throwable(eParam1Param1);

    static Exception e = new Exception(eParam1);

    String assertCorrect(String expected, String actual, Exception e) throws Exception {
        if (!expected.equals(actual)) {
            throw new IllegalStateException("Expected: " + expected + "; Actual: " + actual, e);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13888().assertCorrect(expected, actual, e);
    }
}
