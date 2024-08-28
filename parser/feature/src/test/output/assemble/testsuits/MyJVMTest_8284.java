public class MyJVMTest_8284 {

    static float[] a = { 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.25387704f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, Float.MAX_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.6563343f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static float c = Float.NaN;

    static float d = Float.NaN;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_2vi_unaln(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8284().test_2vi_unaln(a, b, c, d);
    }
}
