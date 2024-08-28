public class MyJVMTest_11095 {

    static int[] a = { 536710717, 7, 1, -1054256308, 7, -925420763, 7, 8, 2, -976177574 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.05654974733343776, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE };

    int[] test_ci_oppos(int[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11095().test_ci_oppos(a, b);
    }
}
