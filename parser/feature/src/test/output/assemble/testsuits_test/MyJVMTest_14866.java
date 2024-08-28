public class MyJVMTest_14866 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, -9223372036854775808L, -9223372036854775808L, 0, 0 };

    static double[] b = { 0.31192915068830374, Double.NaN, 0.6227089912868488, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0.20202081587918486, Double.MIN_VALUE };

    static long c = -9223372036854775808L;

    static double d = 0d;

    static int ALIGN_OFF = 8;

    long[] test_vi_aln(long[] a, double[] b, long c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14866().test_vi_aln(a, b, c, d);
    }
}
