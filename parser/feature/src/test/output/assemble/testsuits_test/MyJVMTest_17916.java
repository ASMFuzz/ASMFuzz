import java.awt.geom.AffineTransform;

public class MyJVMTest_17916 {

    static String methodname = "2E!fs?%]Ff";

    static double atParam1Param1Param1 = Double.MIN_VALUE;

    static double atParam1Param1Param2 = 0.9030197234789572;

    static double atParam1Param1Param3 = Double.MAX_VALUE;

    static double atParam1Param1Param4 = Double.MIN_VALUE;

    static double atParam1Param1Param5 = Double.POSITIVE_INFINITY;

    static double atParam1Param1Param6 = Double.POSITIVE_INFINITY;

    static AffineTransform atParam1Param1 = new AffineTransform(atParam1Param1Param1, atParam1Param1Param2, atParam1Param1Param3, atParam1Param1Param4, atParam1Param1Param5, atParam1Param1Param6);

    static AffineTransform atParam1 = new AffineTransform(atParam1Param1);

    static AffineTransform at = new AffineTransform(atParam1);

    static Tester prev = null;

    static Tester next = null;

    String extraNTE(String methodname, AffineTransform at) {
        throw new RuntimeException("Unexpected Noninvertible " + "thrown from " + methodname + " for: " + at);
        return methodname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17916().extraNTE(methodname, at);
    }
}
