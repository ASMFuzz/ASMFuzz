import java.awt.geom.AffineTransform;

public class MyJVMTest_11266 {

    static float[] initParam1 = { Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0.42550516f, Float.MAX_VALUE, Float.NaN, 0f };

    static AffineTransform init = new AffineTransform(initParam1);

    static boolean full = false;

    static Tester prev = null;

    static Tester next = null;

    boolean test(AffineTransform init, Tester next, boolean full) {
        throw new RuntimeException("Debug: Forcing failure");
        return full;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11266().test(init, next, full);
    }
}
