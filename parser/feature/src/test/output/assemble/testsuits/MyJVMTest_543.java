public class MyJVMTest_543 {

    static long[] a = { -9223372036854775808L, 0, 0, 5562174833369723313L, 3126903792154538281L, 9223372036854775807L, 9223372036854775807L, 0, 0, 9223372036854775807L };

    static double[] b = { 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.7244678146560947, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_ci_unaln(long[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_543().test_ci_unaln(a, b);
    }
}
