public class MyJVMTest_4609 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.35281161404489825, 0d, Double.MIN_VALUE };

    double[] test_ci(double[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4609().test_ci(a);
    }
}
