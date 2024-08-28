public class MyJVMTest_805 {

    static double[] a = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.24020166513310526, 0d, Double.MAX_VALUE, Double.NaN, 0d, 0.2839791791137255, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] b = { 7.548468997623514E-4, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };

    double[] test_cp_neg(double[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_805().test_cp_neg(a, b);
    }
}
