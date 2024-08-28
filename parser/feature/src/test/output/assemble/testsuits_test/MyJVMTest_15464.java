public class MyJVMTest_15464 {

    static short[] a = { -32768, 32767, -32768, -21819, 0, 32767, 0, 32767, -24896, 32767 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.4494883753858644, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_ci_unaln(short[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15464().test_ci_unaln(a, b);
    }
}
