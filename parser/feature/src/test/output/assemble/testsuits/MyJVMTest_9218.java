public class MyJVMTest_9218 {

    static int[] a = { -114359637, 0, -1040681021, -309106717, 0, 9, 8, 1, 0, 2 };

    static int[] b = { 3, 0, 5, 9, 6, -295809115, 0, 0, 4, 1 };

    static double[] c = { Double.NaN, 0d, 0.22615082007048715, 0.10932072319178054, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, 0.5635239895222541, 0d, Double.MAX_VALUE };

    static double[] d = { Double.NaN, 0.09129642393623161, 0d, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    int[] test_cp_neg(int[] a, int[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9218().test_cp_neg(a, b, c, d);
    }
}
