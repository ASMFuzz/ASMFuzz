public class MyJVMTest_12564 {

    static byte[] a = { -17, -113, -126, -118, -87, -65, -19, 58, -87, 30 };

    static double[] b = { Double.NaN, 0.8726939995064336, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0d, 0.046478559817320186, Double.NaN, Double.NaN };

    static byte c = 127;

    static double d = Double.NEGATIVE_INFINITY;

    byte[] test_vi_neg(byte[] a, double[] b, byte c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12564().test_vi_neg(a, b, c, d);
    }
}
