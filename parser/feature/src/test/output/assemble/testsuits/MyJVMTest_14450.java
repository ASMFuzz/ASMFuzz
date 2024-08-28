public class MyJVMTest_14450 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static double[] b = { Double.NaN, 0.1916554687309452, 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0.7654939530872453 };

    static float c = Float.NEGATIVE_INFINITY;

    static double d = 0.1543748281658479;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_vi_unaln(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14450().test_vi_unaln(a, b, c, d);
    }
}
