public class MyJVMTest_4864 {

    static float[] a = { Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0f };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, 0.43066824446325536, Double.NaN, 0.49536392975810317, Double.MIN_VALUE, Double.NaN, 0d, Double.NaN, Double.MIN_VALUE };

    static float c = Float.MAX_VALUE;

    static double d = Double.MIN_VALUE;

    float[] test_vi_oppos(float[] a, double[] b, float c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4864().test_vi_oppos(a, b, c, d);
    }
}
