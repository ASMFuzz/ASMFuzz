public class MyJVMTest_17310 {

    static double[] a = { 0d, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] b = { Double.NaN, Double.MAX_VALUE, 0.24674803193163142, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.9203090795348184, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double c = Double.POSITIVE_INFINITY;

    static double d = Double.MAX_VALUE;

    int test_2vi_oppos(double[] a, double[] b, double c, double d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17310().test_2vi_oppos(a, b, c, d);
    }
}
