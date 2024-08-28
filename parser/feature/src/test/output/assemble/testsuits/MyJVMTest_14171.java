public class MyJVMTest_14171 {

    static float[] a = { Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE };

    static double[] b = { 0.2351482676433413, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.2669001578864276, Double.NaN, 0d };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_ci_unaln(float[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14171().test_ci_unaln(a, b);
    }
}
