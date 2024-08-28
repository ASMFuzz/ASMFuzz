public class MyJVMTest_5741 {

    static float[] a = { 0f, 0.6018248f, 0f, 0f, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0.6498973f, 0.2350496f, Float.MAX_VALUE };

    static float[] b = { Float.NaN, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.NaN, 0f, 0.046630323f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    static float c = Float.MIN_VALUE;

    static float d = 0.45046473f;

    static int ALIGN_OFF = 8;

    float[] test_2vi_aln(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5741().test_2vi_aln(a, b, c, d);
    }
}
