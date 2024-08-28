public class MyJVMTest_14413 {

    static short[] a = { -27859, -32768, 32767, 32767, 32767, 27780, -32768, 32767, -10681, 0 };

    static short[] b = { -32768, 0, 32767, -32768, -32768, 0, 0, 0, 16551, -32768 };

    static float[] c = { Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f };

    static float[] d = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.18898946f, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14413().test_cp_unalndst(a, b, c, d);
    }
}
