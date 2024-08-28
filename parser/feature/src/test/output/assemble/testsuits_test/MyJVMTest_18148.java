public class MyJVMTest_18148 {

    static long[] a = { -6167541543779515701L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 625404938052702990L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, -4118063797218807320L, -2189566266796017916L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static float[] c = { Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0.35578638f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] d = { Float.NaN, Float.NaN, 0.68066263f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18148().test_cp_unalndst(a, b, c, d);
    }
}
