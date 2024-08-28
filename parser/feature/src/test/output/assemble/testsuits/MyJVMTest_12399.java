public class MyJVMTest_12399 {

    static long[] a = { 3735247123052823789L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -7544306468628450130L, 9223372036854775807L, -9223372036854775808L, 1631547876389939826L, 9223372036854775807L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 3416796100522079163L, 9223372036854775807L, 0, 0, -9223372036854775808L, 0, 9223372036854775807L };

    static double[] c = { Double.MAX_VALUE, Double.MAX_VALUE, 0d, 0.432525293293892, Double.NaN, 0.36696345597806024, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE };

    static double[] d = { 0.40348766722484075, 0d, Double.POSITIVE_INFINITY, 0.7731668572745467, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12399().test_cp_unalnsrc(a, b, c, d);
    }
}
