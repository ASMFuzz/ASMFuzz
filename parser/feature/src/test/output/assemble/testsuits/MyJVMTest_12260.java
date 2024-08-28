public class MyJVMTest_12260 {

    static long[] a = { -124372420396107488L, 9223372036854775807L, 9105692136937715372L, 6164009003988685764L, 0, 9223372036854775807L, 0, -9223372036854775808L, 0, 0 };

    static long[] b = { 0, -124848416774693868L, 0, 0, -9223372036854775808L, 0, -9223372036854775808L, -5611138369306733840L, 0, -9223372036854775808L };

    static float[] c = { 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.27083755f, 0.89659345f, 0f, 0.7205676f, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] d = { Float.MIN_VALUE, 0.38573277f, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.14429706f, 0.49737763f };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12260().test_cp_alnsrc(a, b, c, d);
    }
}
