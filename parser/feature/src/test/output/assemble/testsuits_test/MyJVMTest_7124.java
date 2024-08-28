public class MyJVMTest_7124 {

    static double[] a = { Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.76137539149092, Double.NEGATIVE_INFINITY };

    static double[] b = { 0d, Double.NaN, 0d, Double.NaN, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE };

    static int OFFSET = 3;

    double[] test_cp_off(double[] a, double[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7124().test_cp_off(a, b);
    }
}
