public class MyJVMTest_9569 {

    static double[] a = { Double.NaN, Double.NaN, Double.MAX_VALUE, 0d, Double.MAX_VALUE, Double.NaN, 0.18736370727784146, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static double[] b = { Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY };

    double[] test_2ci(double[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9569().test_2ci(a, b);
    }
}
