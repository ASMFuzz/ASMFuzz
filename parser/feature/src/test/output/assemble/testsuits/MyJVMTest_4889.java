import java.awt.geom.AffineTransform;

public class MyJVMTest_4889 {

    static AffineTransform init = new AffineTransform();

    static Tester next = null;

    static boolean full = true;

    boolean test(AffineTransform init, Tester next, boolean full) {
        throw new RuntimeException("Debug: Forcing failure");
        return full;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4889().test(init, next, full);
    }
}
