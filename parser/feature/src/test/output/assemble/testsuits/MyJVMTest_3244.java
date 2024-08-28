public class MyJVMTest_3244 {

    static byte[] a = { 105, 115, 70, -6, 61, -4, -18, -49, -126, 37 };

    static double[] b = { 0.9728657181712073, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.9986631148968722, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY };

    static byte c = -128;

    static double d = 0.4112929664511955;

    byte[] test_vi_neg(byte[] a, double[] b, byte c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3244().test_vi_neg(a, b, c, d);
    }
}
