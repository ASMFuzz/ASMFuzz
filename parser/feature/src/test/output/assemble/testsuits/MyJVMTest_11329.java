public class MyJVMTest_11329 {

    static short[] a = { -32768, 0, 32767, 0, -4490, 0, 0, -32768, -32768, -1104 };

    static double[] b = { 0.674782480106796, 0d, 0d, 0.8034205045681037, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static short c = 32767;

    static double d = Double.NEGATIVE_INFINITY;

    short[] test_vi_oppos(short[] a, double[] b, short c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11329().test_vi_oppos(a, b, c, d);
    }
}
