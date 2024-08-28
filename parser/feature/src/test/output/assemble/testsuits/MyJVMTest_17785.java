import java.awt.geom.AffineTransform;

public class MyJVMTest_17785 {

    static String methodname = "K$G%>smyG#";

    static float[] atParam1 = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, 0f, Float.NaN, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static AffineTransform at = new AffineTransform(atParam1);

    static Tester prev = null;

    static Tester next = null;

    String missingNTE(String methodname, AffineTransform at) {
        throw new RuntimeException("Noninvertible was not " + "thrown from " + methodname + " for: " + at);
        return methodname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17785().missingNTE(methodname, at);
    }
}
