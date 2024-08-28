public class MyJVMTest_17860 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, 0.5835925f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.4223919f };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static float c = Float.NEGATIVE_INFINITY;

    static float d = Float.NEGATIVE_INFINITY;

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
        new MyJVMTest_17860().test_2vi_unaln(a, b, c, d);
    }
}
