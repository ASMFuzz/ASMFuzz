public class MyJVMTest_7493 {

    static short[] a = { -31963, -32768, 0, 32767, 32767, -31400, 0, -32768, -21980, 32767 };

    static short[] b = { 0, 32767, 0, -32768, 7009, 16489, 32767, 32767, 28282, -32768 };

    static float[] c = { Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, 0.7763955f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0.4730671f, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    static float[] d = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.6695377f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7493().test_cp_unalnsrc(a, b, c, d);
    }
}
