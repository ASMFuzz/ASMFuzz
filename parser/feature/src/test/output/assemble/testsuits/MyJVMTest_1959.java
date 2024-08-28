public class MyJVMTest_1959 {

    static byte[] a = { -60, -49, 21, -29, -32, -79, -77, -53, 59, 53 };

    static byte[] b = { -80, 34, 112, 76, -64, -85, 70, -118, -126, -69 };

    static double[] c = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, 0.10069503299710558, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] d = { 0.7536832388212459, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, 0.9502543322402064 };

    byte[] test_cp_neg(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1959().test_cp_neg(a, b, c, d);
    }
}
