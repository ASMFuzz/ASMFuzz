public class MyJVMTest_7247 {

    static byte[] a = { 127, 121, 95, 19, 74, -33, 85, -78, 92, 7 };

    static double[] b = { Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, 0.4550672304421749, 0d, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7247().test_ci_unaln(a, b);
    }
}
