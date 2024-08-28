public class MyJVMTest_13929 {

    static int[] a = { 6, 0, -538759143, 7, 0, 0, -200018299, 4, 3, 2 };

    static int[] b = { 9, -615592888, 4, 1434425009, 0, 4, 1, -1360717037, 0, 6 };

    static double[] c = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.11569656449257237, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE };

    static double[] d = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13929().test_cp_alnsrc(a, b, c, d);
    }
}
