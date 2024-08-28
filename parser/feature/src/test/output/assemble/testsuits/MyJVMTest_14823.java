public class MyJVMTest_14823 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0.3078026824774702, Double.MAX_VALUE, Double.MAX_VALUE, 0d, Double.MAX_VALUE, 0.4729718558465833, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.7428979498066484, Double.MAX_VALUE, 0.29036637325332004, Double.MIN_VALUE, Double.MIN_VALUE };

    static double c = Double.MIN_VALUE;

    static double d = 0d;

    double[] test_2vi(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14823().test_2vi(a, b, c, d);
    }
}
