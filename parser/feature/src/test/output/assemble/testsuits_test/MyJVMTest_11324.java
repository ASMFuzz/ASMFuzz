public class MyJVMTest_11324 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0.75569432296338, 0d, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int SCALE = 2;

    double[] test_2ci_scl(double[] a, double[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.;
            b[i * SCALE] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11324().test_2ci_scl(a, b);
    }
}
