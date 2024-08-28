public class MyJVMTest_75 {

    static int[] a = { 0, -476842791, -1538281072, 0, 0, 0, 2, 5, 0, 3 };

    static int[] b = { 0, 1689009744, 5, 2, 1053039392, 9, 0, 245856246, 2, 0 };

    static double[] c = { 0d, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NaN, 0.6001317147540275, 0.10343850306530511, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] d = { 0d, Double.NEGATIVE_INFINITY, 0.41735319798798876, 0.04044569241151408, Double.MIN_VALUE, Double.MAX_VALUE, 0d, 0.31626724098554315, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    int[] test_cp_neg(int[] a, int[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_75().test_cp_neg(a, b, c, d);
    }
}
