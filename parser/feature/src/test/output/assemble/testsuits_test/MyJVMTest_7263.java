public class MyJVMTest_7263 {

    static short[] a = { -32768, 16599, 32767, -18312, -32768, 0, -32768, 0, -8657, -32768 };

    static short[] b = { -32768, 27099, -5281, -27381, 26765, 32767, 32767, 8747, 0, -11653 };

    static float[] c = { Float.MIN_VALUE, 0.5040532f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0f, Float.MIN_VALUE };

    static float[] d = { Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7263().test_cp_alnsrc(a, b, c, d);
    }
}
