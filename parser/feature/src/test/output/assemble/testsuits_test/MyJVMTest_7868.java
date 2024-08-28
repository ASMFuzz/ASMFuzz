public class MyJVMTest_7868 {

    static byte[] a = { -19, -44, 105, -60, -7, 60, -63, -5, -92, 51 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.053224430650564813, 0.5226160409788251, Double.MAX_VALUE, 0d };

    byte[] test_ci(byte[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7868().test_ci(a, b);
    }
}
