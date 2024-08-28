public class MyJVMTest_11197 {

    static byte[] a = { 62, 114, -54, -1, -61, -121, 69, 18, 80, -67 };

    static byte[] b = { -123, -128, 79, -108, 18, 91, 25, 79, -109, 111 };

    static double[] c = { 0.9374278321102669, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    static double[] d = { 0.09454573463754878, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.12016298026630523 };

    byte[] test_cp_neg(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11197().test_cp_neg(a, b, c, d);
    }
}
