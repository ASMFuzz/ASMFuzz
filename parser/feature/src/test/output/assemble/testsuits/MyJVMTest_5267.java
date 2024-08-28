public class MyJVMTest_5267 {

    static short[] a = { 16137, -18594, -28607, 14153, 25264, -32768, 32767, 32767, 32767, -32768 };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, 0.3837667f, Float.NaN, Float.MAX_VALUE };

    static short c = -32768;

    static float d = 0f;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, float[] b, short c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5267().test_vi_aln(a, b, c, d);
    }
}
