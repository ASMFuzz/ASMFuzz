public class MyJVMTest_8558 {

    static float[] a = { Float.MIN_VALUE, Float.NaN, 0.035983026f, Float.MIN_VALUE, 0.7266746f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.9132712f };

    static double[] c = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0.35576055130510187, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.37506009194556333 };

    static double[] d = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.POSITIVE_INFINITY };

    float[] test_cp_neg(float[] a, float[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8558().test_cp_neg(a, b, c, d);
    }
}
