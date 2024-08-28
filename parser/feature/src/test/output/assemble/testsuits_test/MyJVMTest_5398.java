public class MyJVMTest_5398 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] b = { 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.3314242506940115, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE };

    static double c = Double.MAX_VALUE;

    static double d = 0.9998178539884508;

    double[] test_2vi(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5398().test_2vi(a, b, c, d);
    }
}
