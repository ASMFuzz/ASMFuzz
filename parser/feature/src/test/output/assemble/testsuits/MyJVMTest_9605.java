public class MyJVMTest_9605 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, 0.4804091f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE };

    static float[] b = { Float.NaN, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, 0f };

    static double[] c = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.614728675649386, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static double[] d = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.7434609490094356, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE };

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
        new MyJVMTest_9605().test_cp_unalndst(a, b, c, d);
    }
}
