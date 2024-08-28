public class MyJVMTest_10389 {

    static short[] a = { -32768, -32768, 32767, 32767, 27424, -16793, 32767, -16734, -32768, 0 };

    static double[] b = { Double.MIN_VALUE, Double.NaN, 0d, 0.5957281207332046, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.27800987910351216, Double.NaN };

    static short c = -32768;

    static double d = 0.44488589645929244;

    short[] test_vi_neg(short[] a, double[] b, short c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10389().test_vi_neg(a, b, c, d);
    }
}
