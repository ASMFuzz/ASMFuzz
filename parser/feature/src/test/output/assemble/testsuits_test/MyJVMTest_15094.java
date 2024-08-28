public class MyJVMTest_15094 {

    static byte[] a = { 46, -2, 103, 21, 26, -107, -93, -70, -112, 19 };

    static double[] b = { Double.NEGATIVE_INFINITY, 0d, 0d, 0.7934698247855992, Double.NaN, 0d, Double.NEGATIVE_INFINITY, 0.08602623063975334, 0d, 0d };

    byte[] test_ci_neg(byte[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15094().test_ci_neg(a, b);
    }
}
