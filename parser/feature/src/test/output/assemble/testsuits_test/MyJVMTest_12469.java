public class MyJVMTest_12469 {

    static long[] a = { 9223372036854775807L, 0, 9223372036854775807L, 7309181247463234190L, -9223372036854775808L, 6579201862294412400L, 9223372036854775807L, 0, -8723883844825112124L, -9223372036854775808L };

    static float[] b = { Float.NaN, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, 0.73467356f, Float.MAX_VALUE, 0.90677404f };

    static long c = 9223372036854775807L;

    static float d = Float.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    long[] test_vi_aln(long[] a, float[] b, long c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12469().test_vi_aln(a, b, c, d);
    }
}
