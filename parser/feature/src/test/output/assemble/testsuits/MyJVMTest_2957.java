public class MyJVMTest_2957 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 0, 2064984357441995878L, 0, -1187028108258280782L, -9223372036854775808L, 0, -9223372036854775808L, 0 };

    static long[] b = { 0, 3929538235015348930L, 9223372036854775807L, 0, 9223372036854775807L, 0, 9223372036854775807L, 0, 0, 9223372036854775807L };

    static float[] c = { Float.NaN, 0.62123686f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.5563272f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] d = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, 0.8110712f, Float.MIN_VALUE, Float.NaN, 0f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2957().test_cp_alnsrc(a, b, c, d);
    }
}
