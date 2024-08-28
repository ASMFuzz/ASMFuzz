public class MyJVMTest_16644 {

    static double[] a = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.5809528913054249, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN, Double.POSITIVE_INFINITY };

    static double[] b = { 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.31942818469300005, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE };

    static int OFFSET = 3;

    double[] test_cp_off(double[] a, double[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16644().test_cp_off(a, b);
    }
}
