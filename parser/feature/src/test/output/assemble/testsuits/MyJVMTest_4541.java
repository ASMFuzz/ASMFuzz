public class MyJVMTest_4541 {

    static int[] a = { 9, 445695252, 0, 4, 2, 6, 0, 8, 0, -1878108272 };

    static int[] b = { 584816554, 0, -1895599439, 1483477758, 7, 0, -1319494459, -1300757290, 1283242260, 3 };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN };

    static double[] d = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.4585632971045013, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0d };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4541().test_cp_alnsrc(a, b, c, d);
    }
}
