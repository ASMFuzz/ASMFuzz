public class MyJVMTest_4535 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0.0316631163941693, 0d, 0.2887622485891226, Double.MAX_VALUE };

    static double[] b = { Double.NaN, 0d, Double.NaN, Double.NaN, 0.7032623403524791, Double.NaN, 0.004050846432246846, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double c = 0d;

    static double d = Double.MAX_VALUE;

    static int OFFSET = 3;

    double[] test_2vi_off(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4535().test_2vi_off(a, b, c, d);
    }
}
