public class MyJVMTest_6009 {

    static short[] a = { 21898, 0, 0, 25572, -2945, -12671, 5871, -32768, 18480, 14358 };

    static double[] b = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.9375958477031574, 0.47031699202768185, 0.5816358762241153, Double.NaN };

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
        new MyJVMTest_6009().test_ci_unaln(a, b);
    }
}
