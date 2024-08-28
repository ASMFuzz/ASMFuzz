public class MyJVMTest_445 {

    static float[] a = { Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.908727f };

    static float[] b = { 0f, 0.30918628f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, 0f, Float.NaN, Float.MAX_VALUE, 0f, Float.MAX_VALUE };

    static double[] c = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MAX_VALUE, 0.9257640092569333, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalndst(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_445().test_cp_unalndst(a, b, c, d);
    }
}
