public class MyJVMTest_9940 {

    static byte[] a = { -75, -2, 120, -104, -92, -53, -98, 32, 3, -72 };

    static byte[] b = { 85, -75, -7, 108, 82, -41, 30, 41, 118, 19 };

    static double[] c = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.9291120733696687, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };

    static double[] d = { 0d, 0.7097106308885187, Double.MIN_VALUE, 0.5201720659868518, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d };

    byte[] test_cp(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9940().test_cp(a, b, c, d);
    }
}
