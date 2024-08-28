public class MyJVMTest_9177 {

    static short[] a = { -32768, -32768, -9828, 32767, 0, 32767, 32767, 32767, -32768, -32768 };

    static short[] b = { -32768, 25016, -32768, 32767, 0, 32767, -32768, 32767, -9185, -20335 };

    static double[] c = { 0.29947417345882055, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.2176790813345043, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0d };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.09466124635567164 };

    short[] test_cp_oppos(short[] a, short[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9177().test_cp_oppos(a, b, c, d);
    }
}
