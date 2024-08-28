public class MyJVMTest_7871 {

    static int[] a = { 9, 4, 105243641, 6, 8, 0, -1063368900, 0, 6, 9 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.1952927060453996, Double.NaN, Double.MAX_VALUE };

    int[] test_ci(int[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7871().test_ci(a, b);
    }
}
