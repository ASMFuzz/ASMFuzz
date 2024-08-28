public class MyJVMTest_1701 {

    static int[] a = { 4, 0, 0, 8, 0, 0, 9, 2, -751732746, 0 };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static int c = 1606703909;

    static double d = Double.MAX_VALUE;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_vi_unaln(int[] a, double[] b, int c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1701().test_vi_unaln(a, b, c, d);
    }
}
