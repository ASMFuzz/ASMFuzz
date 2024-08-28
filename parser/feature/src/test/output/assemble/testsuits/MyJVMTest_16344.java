public class MyJVMTest_16344 {

    static byte[] a = { -20, 12, 59, -43, 53, -48, 49, 54, 113, -104 };

    static byte[] b = { -42, 87, 80, -40, 15, 29, 110, -102, 77, -123 };

    static double[] c = { 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.4132298077955323, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] d = { Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.NaN, 0.17130914203625525, Double.MAX_VALUE, 0.7180555541416254, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.006196011603729734 };

    byte[] test_cp_oppos(byte[] a, byte[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16344().test_cp_oppos(a, b, c, d);
    }
}
