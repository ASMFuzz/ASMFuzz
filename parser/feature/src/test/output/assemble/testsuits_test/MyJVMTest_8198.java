public class MyJVMTest_8198 {

    static byte[] a = { -75, 88, 24, -82, -22, 120, 62, -21, -44, -83 };

    static double[] b = { 0d, 0d, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.4189575910526264, 0.434827623876076, 0.5725712080402455, 0.7560376444024917 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8198().test_ci_aln(a, b);
    }
}
