public class MyJVMTest_6422 {

    static int[] a = { 3, 3, 8, -528672050, 4, 0, 1, 9, 0, 1872937102 };

    static int[] b = { -1825171556, 0, 3, 610611453, 0, 1, 3, -1223014484, 2, -1057007046 };

    static double[] c = { Double.NaN, 0.41028482719544057, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.MAX_VALUE, 0d, 0d };

    static double[] d = { 0d, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    int[] test_cp_oppos(int[] a, int[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6422().test_cp_oppos(a, b, c, d);
    }
}
