public class MyJVMTest_11864 {

    static float[] a = { Float.MAX_VALUE, 0.178509f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE };

    static float[] b = { Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NaN, 0f };

    static double[] c = { Double.NEGATIVE_INFINITY, 0.3149394165076531, 0.892179172836042, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE, 0.9939633454854462, 0.9356067384391442, Double.MIN_VALUE, Double.MIN_VALUE, 0d, 0.2085688441280723 };

    float[] test_cp_oppos(float[] a, float[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11864().test_cp_oppos(a, b, c, d);
    }
}
