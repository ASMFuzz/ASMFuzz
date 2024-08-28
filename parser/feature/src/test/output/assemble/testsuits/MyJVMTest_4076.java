public class MyJVMTest_4076 {

    static float[] a = { Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.8480503f, 0.25877464f, Float.NaN, 0.36175418f, 0.9591623f, Float.POSITIVE_INFINITY };

    static float[] b = { 0.8013544f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static int ALIGN_OFF = 8;

    float[] test_2ci_aln(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4076().test_2ci_aln(a, b);
    }
}
