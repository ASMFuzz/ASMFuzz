public class MyJVMTest_17399 {

    static double[] a = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE };

    static double b = Double.POSITIVE_INFINITY;

    double[] test_vi_neg(double[] a, double b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17399().test_vi_neg(a, b);
    }
}
