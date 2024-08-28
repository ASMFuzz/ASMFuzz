public class MyJVMTest_7839 {

    static double[] a = { 0.3531996696638122, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static double b = Double.MAX_VALUE;

    double[] test_vi_neg(double[] a, double b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7839().test_vi_neg(a, b);
    }
}
