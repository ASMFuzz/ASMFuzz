public class MyJVMTest_10175 {

    static short[] a = { -32768, 32767, 0, -32768, 0, 0, 32767, 32767, -32768, 32767 };

    static short[] b = { 32767, -32768, 0, 32767, -32768, 32767, 3407, 0, -28208, -32768 };

    static float[] c = { Float.MAX_VALUE, 0f, Float.MIN_VALUE, 0f, 0f, Float.NaN, 0.07494724f, 0.14918602f, 0f, Float.MIN_VALUE };

    static float[] d = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0f, 0.42858797f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10175().test_cp_alndst(a, b, c, d);
    }
}
