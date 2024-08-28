public class MyJVMTest_5450 {

    static float[] a = { 0f, Float.NEGATIVE_INFINITY, 0f, 0.58606195f, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MIN_VALUE, Float.NaN, 0f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.7993383f };

    static double[] c = { Double.MAX_VALUE, Double.MAX_VALUE, 0.7126814421793773, 0d, 0d, 0.6490938700313209, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE };

    static double[] d = { Double.MAX_VALUE, Double.MAX_VALUE, 0d, 0d, Double.NaN, 0.8757893208849435, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    float[] test_cp(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5450().test_cp(a, b, c, d);
    }
}
