public class MyJVMTest_6128 {

    static short[] a = { 6249, 32767, -32768, -32768, -32768, 0, 32767, 32767, 19408, 0 };

    static double[] b = { 0.015422550904585552, Double.NaN, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN };

    short[] test_ci_oppos(short[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6128().test_ci_oppos(a, b);
    }
}
