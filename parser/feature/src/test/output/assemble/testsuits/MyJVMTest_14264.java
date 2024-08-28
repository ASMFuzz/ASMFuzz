public class MyJVMTest_14264 {

    static float[] a = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, 0.8566561f, Float.MIN_VALUE, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.MAX_VALUE, 0d, 0.29058530782810976, Double.MAX_VALUE };

    static float c = 0.5285963f;

    static double d = 0d;

    float[] test_vi_oppos(float[] a, double[] b, float c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14264().test_vi_oppos(a, b, c, d);
    }
}
