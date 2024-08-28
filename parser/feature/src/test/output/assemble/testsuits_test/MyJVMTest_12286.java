public class MyJVMTest_12286 {

    static short[] a = { 32767, -15531, 31482, -32768, 14408, 32767, 2814, -32768, 0, 0 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    short[] test_ci(short[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12286().test_ci(a, b);
    }
}
