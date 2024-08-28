import java.awt.geom.AffineTransform;

public class MyJVMTest_8212 {

    static String methodname = "XKr#NwBC+f";

    static AffineTransform at = new AffineTransform();

    static Tester prev = null;

    static Tester next = null;

    String missingNTE(String methodname, AffineTransform at) {
        throw new RuntimeException("Noninvertible was not " + "thrown from " + methodname + " for: " + at);
        return methodname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8212().missingNTE(methodname, at);
    }
}
