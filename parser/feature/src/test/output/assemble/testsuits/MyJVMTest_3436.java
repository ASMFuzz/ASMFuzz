public class MyJVMTest_3436 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0.6493150244839317, Double.NaN, Double.NaN };

    static double b = 0d;

    static int OFFSET = 3;

    double[] test_vi_off(double[] a, double b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3436().test_vi_off(a, b);
    }
}
