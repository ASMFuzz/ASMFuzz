public class MyJVMTest_18149 {

    static float[] a = { Float.POSITIVE_INFINITY, 0f, 0f, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0.33346677f, 0.9237689f };

    static float[] b = { Float.NEGATIVE_INFINITY, 0.7065007f, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f };

    static double[] c = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.38131688493235716, Double.MIN_VALUE, 0.7764827725958472, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] d = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.7002973491017582, 0.9299629466435815 };

    float[] test_cp_neg(float[] a, float[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18149().test_cp_neg(a, b, c, d);
    }
}
