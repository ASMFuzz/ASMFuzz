public class MyJVMTest_2078 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.NaN, 0.20416703158592608, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE };

    static double[] b = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0d };

    static int SCALE = 2;

    double[] test_2ci_scl(double[] a, double[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.;
            b[i * SCALE] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2078().test_2ci_scl(a, b);
    }
}
