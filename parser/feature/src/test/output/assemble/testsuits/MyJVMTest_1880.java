public class MyJVMTest_1880 {

    static int[] a = { 2, 0, 7, 2, 0, 1, 6, 2, 0, 0 };

    static int[] b = { 1092159111, 0, 3, 9, 0, 4, 1100067831, 1087135281, 7, 1534292341 };

    static double[] c = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN };

    static double[] d = { 0.5703592140865656, Double.MIN_VALUE, 0.718066039561895, Double.NEGATIVE_INFINITY, 0d, 0.5295829501497004, 0d, 0.40582298267305383, Double.NaN, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1880().test_cp_unalndst(a, b, c, d);
    }
}
