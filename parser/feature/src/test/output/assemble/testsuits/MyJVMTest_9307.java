public class MyJVMTest_9307 {

    static long[] a = { -9223372036854775808L, -5314228074236728737L, 2657263464564543774L, 0, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 324229521263450111L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 1109029041399654672L, 0, 0, -9223372036854775808L, -647097598823792259L, 5726681767113616040L };

    static long c = 9223372036854775807L;

    static long d = 1976243974509716232L;

    static int ALIGN_OFF = 8;

    long[] test_2vi_aln(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9307().test_2vi_aln(a, b, c, d);
    }
}
