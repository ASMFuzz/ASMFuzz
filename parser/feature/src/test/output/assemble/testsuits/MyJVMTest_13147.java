public class MyJVMTest_13147 {

    static long[] a = { 8362611613479156466L, -9223372036854775808L, 9223372036854775807L, -8900656161312342843L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.8648518905992159, 0d, 0d, Double.NaN };

    static long c = -985189175815431457L;

    static double d = Double.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_vi_unaln(long[] a, double[] b, long c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13147().test_vi_unaln(a, b, c, d);
    }
}
