public class MyJVMTest_3806 {

    static long[] a = { -9223372036854775808L, 2743103936724903419L, 7736271513528422783L, 0, -9223372036854775808L, 0, -9223372036854775808L, -36761418239091051L, 2672517359214526439L, 9223372036854775807L };

    static double[] b = { Double.POSITIVE_INFINITY, 0.3127883623275496, Double.POSITIVE_INFINITY, 0d, 0.358049882647248, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE };

    static long c = 9223372036854775807L;

    static double d = Double.NaN;

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
        new MyJVMTest_3806().test_vi_unaln(a, b, c, d);
    }
}
