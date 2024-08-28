public class MyJVMTest_6839 {

    static byte[] a = { -49, -43, -108, -113, -28, -121, 41, -12, -46, -38 };

    static byte[] b = { 21, 113, -124, -87, 96, 98, 49, -62, 30, 33 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, 0.8611562216356826, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] d = { Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0.8042680586279841, Double.NaN, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0.6506112324079008 };

    byte[] test_cp_oppos(byte[] a, byte[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6839().test_cp_oppos(a, b, c, d);
    }
}
