public class MyJVMTest_12179 {

    static byte[] a = { 22, -125, 101, 109, 93, 74, 31, -95, 111, -106 };

    static byte[] b = { -43, -60, 119, -59, -100, 50, -27, 51, 75, 73 };

    static double[] c = { 0.8396224850982876, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d };

    static double[] d = { Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.6881976305401207, Double.NEGATIVE_INFINITY, Double.NaN, 0.20810485826980452 };

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
        new MyJVMTest_12179().test_cp_unalndst(a, b, c, d);
    }
}
