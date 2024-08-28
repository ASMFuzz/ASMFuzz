public class MyJVMTest_14688 {

    static short[] a = { -16714, 0, 0, 0, 1099, 32767, -32768, -32768, 0, -32768 };

    static float[] b = { 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.6656094f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static short c = 32767;

    static float d = Float.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, float[] b, short c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14688().test_vi_aln(a, b, c, d);
    }
}
