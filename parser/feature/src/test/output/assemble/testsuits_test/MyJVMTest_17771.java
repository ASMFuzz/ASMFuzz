public class MyJVMTest_17771 {

    static byte[] a = { 49, -26, 68, -84, 119, -74, -113, 75, 97, -29 };

    static double[] b = { Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17771().test_ci_aln(a, b);
    }
}
