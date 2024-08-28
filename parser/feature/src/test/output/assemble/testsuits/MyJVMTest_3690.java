public class MyJVMTest_3690 {

    static double[] a = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0.45225676324483577, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0.48013627773548273 };

    static double[] b = { Double.NEGATIVE_INFINITY, 0.14271763355018197, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    double[] test_2ci_neg(double[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3690().test_2ci_neg(a, b);
    }
}
