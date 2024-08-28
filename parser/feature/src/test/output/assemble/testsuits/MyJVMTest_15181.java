public class MyJVMTest_15181 {

    static int[] a = { 0, 0, 0, 7, 0, 102374383, 7, 1, 1402885836, 5 };

    static int[] b = { 4, 0, 5, 3, 0, -760162185, 0, 1, 5, 4 };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, 0d, 0d, 0d, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] d = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.020763073837373636, 0.906115326732572, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    int[] test_cp(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15181().test_cp(a, b, c, d);
    }
}
