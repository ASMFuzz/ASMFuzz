public class MyJVMTest_5921 {

    static byte[] a = { 69, -21, 8, 0, 6, -46, 106, 96, -11, 108 };

    static double[] b = { Double.MIN_VALUE, 0d, Double.MAX_VALUE, 0.9986706530173204, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, 0d };

    static byte c = 2;

    static double d = Double.MIN_VALUE;

    byte[] test_vi(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5921().test_vi(a, b, c, d);
    }
}
