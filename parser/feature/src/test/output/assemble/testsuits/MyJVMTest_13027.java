public class MyJVMTest_13027 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, 0.9397143658124144, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.4439026770811356, Double.MIN_VALUE, 0d, 0d };

    static double[] b = { 0.30531179934626207, 0d, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    double[] test_2ci_neg(double[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13027().test_2ci_neg(a, b);
    }
}
