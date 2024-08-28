public class MyJVMTest_13999 {

    static double[] a = { Double.MIN_VALUE, Double.NaN, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0.5737123660111391, Double.MIN_VALUE };

    double[] test_ci(double[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13999().test_ci(a);
    }
}
