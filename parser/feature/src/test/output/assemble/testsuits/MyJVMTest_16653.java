public class MyJVMTest_16653 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 5414777808811010787L, -9223372036854775808L, 9223372036854775807L, 0, -1622110432255774006L, -9223372036854775808L };

    static long[] b = { 0, 9223372036854775807L, 9223372036854775807L, -7292130428372754549L, -9223372036854775808L, 0, 9223372036854775807L, 0, -9223372036854775808L, 0 };

    static double[] c = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0d, 0.11969580771462807, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN };

    static double[] d = { Double.NEGATIVE_INFINITY, 0.49489360506084845, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, 0d, 0.6831079589941508 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16653().test_cp_unalndst(a, b, c, d);
    }
}
