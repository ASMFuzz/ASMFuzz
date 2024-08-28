public class MyJVMTest_6821 {

    static byte[] a = { 109, 29, -74, -95, -30, -100, -94, -33, 53, 23 };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.6697288151264077, 0d, 0.043242821755405836, Double.NEGATIVE_INFINITY, 0.20180711273051632, Double.NaN };

    static byte c = -128;

    static double d = Double.POSITIVE_INFINITY;

    byte[] test_vi_oppos(byte[] a, double[] b, byte c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6821().test_vi_oppos(a, b, c, d);
    }
}
