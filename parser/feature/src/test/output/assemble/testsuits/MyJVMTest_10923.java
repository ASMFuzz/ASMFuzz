public class MyJVMTest_10923 {

    static int[] a = { -1614351824, 0, 8, 1241271967, 1, 1, 0, 0, 0, 2 };

    static double[] b = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, 0d, Double.NaN, Double.MIN_VALUE };

    static int c = 2063246189;

    static double d = 0.13117935352363874;

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
        new MyJVMTest_10923().test_vi_unaln(a, b, c, d);
    }
}
