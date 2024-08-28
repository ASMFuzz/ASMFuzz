public class MyJVMTest_13434 {

    static float[] a = { 0f, 0.79122615f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.7128165f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.9848054f, 0.519862f, 0f };

    static float[] b = { Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0.65239f, 0.6014412f, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_2ci_aln(float[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13434().test_2ci_aln(a, b);
    }
}
