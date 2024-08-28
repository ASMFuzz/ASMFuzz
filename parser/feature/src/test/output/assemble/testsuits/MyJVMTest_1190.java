public class MyJVMTest_1190 {

    static short[] a = { 32767, -32768, 0, 32767, 0, 32767, -32768, 32767, 8303, -21039 };

    static double[] b = { 0.12988972592522097, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.349135985533789, 0d, Double.POSITIVE_INFINITY };

    static short c = -17938;

    static double d = Double.POSITIVE_INFINITY;

    short[] test_vi_neg(short[] a, double[] b, short c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1190().test_vi_neg(a, b, c, d);
    }
}
