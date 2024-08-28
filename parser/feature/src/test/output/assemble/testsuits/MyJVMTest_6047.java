public class MyJVMTest_6047 {

    static double[] a = { Double.NaN, 0d, 0d, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, 0.850108409160079 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.NaN, 0.5159413909085533, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN };

    static int OFFSET = 3;

    double[] test_2ci_off(double[] a, double[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.;
            b[i + OFFSET] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6047().test_2ci_off(a, b);
    }
}
