public class MyJVMTest_17813 {

    static long[] a = { 3901676530114075609L, -1192007547123542951L, 9223372036854775807L, 5372962750927631467L, -9223372036854775808L, -3722929405312056482L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] b = { 9223372036854775807L, 6125666747821248809L, -9223372036854775808L, -9223372036854775808L, 1791786844884903990L, -1237585262340256194L, 9223372036854775807L, -9223372036854775808L, 2264853877095059967L, 9223372036854775807L };

    static float[] c = { 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f };

    static float[] d = { Float.NaN, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0.7663765f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0.13130546f, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17813().test_cp_unalnsrc(a, b, c, d);
    }
}
