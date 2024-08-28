public class MyJVMTest_38 {

    static short[] a = { -32768, -32768, -6062, -32768, 32767, -32768, 0, -32768, 26259, -32768 };

    static short[] b = { 20479, 0, 21903, -32768, 32767, 32767, 32767, 32767, 32767, 0 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0.1982301831274753, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, Double.NaN, 0d };

    static double[] d = { Double.NaN, 0d, 0.2837973502613209, 0d, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    short[] test_cp_oppos(short[] a, short[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_38().test_cp_oppos(a, b, c, d);
    }
}
