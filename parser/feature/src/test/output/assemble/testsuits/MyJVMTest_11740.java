public class MyJVMTest_11740 {

    static byte[] a = { -123, 114, -19, 98, -124, 50, -127, -40, -74, -91 };

    static double[] b = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static byte c = -128;

    static double d = 0.3120136360035457;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11740().test_vi_aln(a, b, c, d);
    }
}
