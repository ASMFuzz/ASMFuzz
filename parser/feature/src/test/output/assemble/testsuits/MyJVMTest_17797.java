public class MyJVMTest_17797 {

    static byte[] a = { -127, 34, -91, -31, 56, -82, 8, -8, 96, -100 };

    static byte[] b = { 5, -14, -12, 22, -47, -116, -30, 53, 124, -29 };

    static double[] c = { Double.NaN, Double.MIN_VALUE, 0.18723912857256464, 0.5759302590092233, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { 0d, 0.6732371103602832, Double.NaN, 0.24142273771998224, Double.POSITIVE_INFINITY, 0d, 0.7055179816544569, 0d, 0d, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17797().test_cp_alndst(a, b, c, d);
    }
}
