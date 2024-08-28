public class MyJVMTest_7918 {

    static double[] a = { 0d, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.NaN, 0.05072783184484431, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.6497333198558436 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0.39642649917813577, Double.NEGATIVE_INFINITY, 0.9840929852538698, Double.POSITIVE_INFINITY, 0.1558888440757752, Double.MIN_VALUE };

    static double c = 0d;

    static double d = Double.NEGATIVE_INFINITY;

    double[] test_2vi_neg(double[] a, double[] b, double c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7918().test_2vi_neg(a, b, c, d);
    }
}
