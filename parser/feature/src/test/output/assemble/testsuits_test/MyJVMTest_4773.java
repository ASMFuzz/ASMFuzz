public class MyJVMTest_4773 {

    static float[] a = { Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, 0f };

    static double[] b = { 0d, Double.NaN, 0d, Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

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
        new MyJVMTest_4773().test_ci_unaln(a, b);
    }
}
