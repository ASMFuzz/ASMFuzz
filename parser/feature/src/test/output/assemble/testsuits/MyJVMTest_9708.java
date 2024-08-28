public class MyJVMTest_9708 {

    static long[] a = { 0, 5120799699370639689L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.9365108185125972, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0.11802750135617279, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.3560180473181843 };

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
        new MyJVMTest_9708().test_ci_unaln(a, b);
    }
}
