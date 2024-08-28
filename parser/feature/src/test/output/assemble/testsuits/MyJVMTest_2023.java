import java.awt.geom.AffineTransform;

public class MyJVMTest_2023 {

    static AffineTransform init = new AffineTransform();

    static boolean full = true;

    static Tester prev = null;

    static Tester next = null;

    boolean test(AffineTransform init, Tester next, boolean full) {
        throw new RuntimeException("Debug: Forcing failure");
        return full;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2023().test(init, next, full);
    }
}
