public class MyJVMTest_15102 {

    static byte[] a = { 35, 86, 96, 17, -29, 12, -98, -111, 70, 96 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN };

    static byte c = -92;

    static double d = 0d;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15102().test_vi_unaln(a, b, c, d);
    }
}
