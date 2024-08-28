public class MyJVMTest_2881 {

    static byte[] a = { -56, 51, -7, -74, 126, 72, 109, 91, -4, 26 };

    static byte[] b = { -106, -82, 3, 120, 18, -103, 46, 7, -18, -115 };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY };

    static double[] d = { 0d, Double.MAX_VALUE, 0.5459621015108291, 0.6416614198467312, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.15666177310275298 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2881().test_cp_unalndst(a, b, c, d);
    }
}
