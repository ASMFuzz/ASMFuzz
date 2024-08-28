public class MyJVMTest_14381 {

    static long[] a = { 4521973555977194900L, -9223372036854775808L, 813576635815713977L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 8272970479484268498L };

    static long[] b = { 6738068933817075599L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 2386006240081982259L, -9223372036854775808L, -9223372036854775808L, 2054735506499710736L, 0, 0 };

    static double[] c = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.9768531207904463, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN };

    static double[] d = { Double.MAX_VALUE, 0d, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.5889066250183208, Double.MAX_VALUE, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14381().test_cp_alndst(a, b, c, d);
    }
}
