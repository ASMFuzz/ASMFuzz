public class MyJVMTest_15184 {

    static float[] a = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static float c = 0.6408301f;

    static float d = 0f;

    static int ALIGN_OFF = 8;

    float[] test_2vi_aln(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15184().test_2vi_aln(a, b, c, d);
    }
}
