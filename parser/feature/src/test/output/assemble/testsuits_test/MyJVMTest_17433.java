public class MyJVMTest_17433 {

    static int[] a = { 6, 7, -172913015, 3, 0, 0, 0, -1203076037, 9, 2 };

    static double[] b = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY };

    int[] test_ci(int[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17433().test_ci(a, b);
    }
}
