public class MyJVMTest_5739 {

    static int[] a = { 2, 1220628980, 3, 4, 496185024, -538044868, 0, 7, 5, 1868515192 };

    static int[] b = { 0, 5, 1546848584, 5, 6, 8, 3, 0, 3, 0 };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, 0d, Double.MAX_VALUE };

    static double[] d = { 0.51304295326293, Double.NaN, 0.3942581700828449, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0.34894916111121144 };

    int[] test_cp(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5739().test_cp(a, b, c, d);
    }
}
