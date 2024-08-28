public class MyJVMTest_989 {

    static short[] a = { -32768, 32767, 31842, 0, 3811, 0, 32767, 32767, 32767, -32768 };

    static short[] b = { 32767, -32768, 0, -32768, 0, -32768, 32767, 0, 32767, 0 };

    static float[] c = { 0.743068f, 0f, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.55834645f, Float.MIN_VALUE };

    static float[] d = { 0.957199f, 0.30339062f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MIN_VALUE, 0f, 0.34788555f };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_989().test_cp_alndst(a, b, c, d);
    }
}
