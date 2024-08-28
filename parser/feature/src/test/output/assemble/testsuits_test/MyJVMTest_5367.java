public class MyJVMTest_5367 {

    static short[] a = { 0, -32768, -32768, -32768, 32767, 0, -7364, -32768, -31341, 0 };

    static double[] b = { Double.MIN_VALUE, 0d, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.3233749601314231, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static short c = 0;

    static double d = Double.MAX_VALUE;

    short[] test_vi(short[] a, double[] b, short c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5367().test_vi(a, b, c, d);
    }
}
