public class MyJVMTest_3546 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0d };

    static double[] b = { Double.MAX_VALUE, 0d, 0.7228154875461301, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    double[] test_cp(double[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3546().test_cp(a, b);
    }
}
