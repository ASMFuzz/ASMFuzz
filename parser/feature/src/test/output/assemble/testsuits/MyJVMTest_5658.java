public class MyJVMTest_5658 {

    static byte[] a = { -32, -61, -45, -110, 23, -61, -77, 123, 50, -39 };

    static double[] b = { Double.NEGATIVE_INFINITY, 0.47825505678508173, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.6033309783959356, 0.7168256320678283, 0d, 0d, 0.8342074938069729, Double.NaN };

    byte[] test_ci_neg(byte[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5658().test_ci_neg(a, b);
    }
}
