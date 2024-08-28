public class MyJVMTest_2083 {

    static short[] a = { -32768, 32767, 0, -32768, 0, -32768, -32768, -32768, -32768, 0 };

    static double[] b = { 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0d, 0d, Double.NaN, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY };

    static short c = 32767;

    static double d = Double.MIN_VALUE;

    short[] test_vi_oppos(short[] a, double[] b, short c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2083().test_vi_oppos(a, b, c, d);
    }
}
