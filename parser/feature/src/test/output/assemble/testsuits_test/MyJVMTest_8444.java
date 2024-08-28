public class MyJVMTest_8444 {

    static int[] a = { 0, 0, 0, -594601102, 2, 0, 2062125404, 2, 0, 0 };

    static int[] b = { 7, 6, 2, 0, 6, 1007443355, 0, -1027963889, 1372921047, 9 };

    static double[] c = { 0d, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, 0.19046746277578197, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.40995433766015665, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8444().test_cp_alndst(a, b, c, d);
    }
}
