public class MyJVMTest_8223 {

    static byte[] a = { 81, -95, 119, -30, 122, 104, 53, 72, -111, -91 };

    static byte[] b = { 97, -120, -21, -82, -89, -39, 72, -116, 38, -73 };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] d = { Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0d, 0.48651378907949616 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8223().test_cp_alndst(a, b, c, d);
    }
}
