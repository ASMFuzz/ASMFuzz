public class MyJVMTest_17480 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.MAX_VALUE, 0d };

    static double[] b = { Double.MIN_VALUE, Double.NaN, Double.NaN, 0d, Double.MIN_VALUE, 0.3474245591659789, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.POSITIVE_INFINITY };

    static double c = Double.NaN;

    static double d = Double.MIN_VALUE;

    double[] test_2vi_neg(double[] a, double[] b, double c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17480().test_2vi_neg(a, b, c, d);
    }
}
