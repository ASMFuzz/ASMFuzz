import java.awt.geom.AffineTransform;

public class MyJVMTest_14289 {

    static double[] initParam1 = { 0.9259717927949127, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d };

    static AffineTransform init = new AffineTransform(initParam1);

    static Tester next = null;

    static boolean full = false;

    boolean test(AffineTransform init, Tester next, boolean full) {
        throw new RuntimeException("Debug: Forcing failure");
        return full;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14289().test(init, next, full);
    }
}
