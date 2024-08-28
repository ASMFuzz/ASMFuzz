import java.awt.geom.AffineTransform;

public class MyJVMTest_8336 {

    static String methodname = "\"}U;(K7LJo";

    static AffineTransform at = new AffineTransform();

    static Tester prev = null;

    static Tester next = null;

    String extraNTE(String methodname, AffineTransform at) {
        throw new RuntimeException("Unexpected Noninvertible " + "thrown from " + methodname + " for: " + at);
        return methodname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8336().extraNTE(methodname, at);
    }
}
