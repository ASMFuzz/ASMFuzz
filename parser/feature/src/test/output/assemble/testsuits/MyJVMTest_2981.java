public class MyJVMTest_2981 {

    static short[] a = { -9718, 32767, 0, -32768, 0, 32767, -30045, -32768, -19760, 18589 };

    static double[] b = { Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0.04101141081670956, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.7919198262163691, Double.NaN };

    short[] test_ci(short[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2981().test_ci(a, b);
    }
}
