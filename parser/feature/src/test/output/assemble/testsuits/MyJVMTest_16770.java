public class MyJVMTest_16770 {

    static byte[] a = { -73, 54, 20, 71, 106, -118, -125, -9, 85, -27 };

    static double[] b = { Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16770().test_ci_unaln(a, b);
    }
}
