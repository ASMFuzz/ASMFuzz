public class MyJVMTest_5039 {

    static float[] a = { Float.MAX_VALUE, 0.56807876f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0f, 0f, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    static double[] b = { Double.MIN_VALUE, 0.22480740472434002, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    static float c = Float.NEGATIVE_INFINITY;

    static double d = Double.NEGATIVE_INFINITY;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_vi_unaln(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5039().test_vi_unaln(a, b, c, d);
    }
}
