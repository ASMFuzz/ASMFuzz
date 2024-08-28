public class MyJVMTest_11109 {

    static int[] a = { 939019718, 0, 6, 4, 6, 3, 0, 0, -579315663, 0 };

    static int[] b = { 1, -1411720341, 7, 5, 0, 4, 0, 0, 0, 0 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0.38722633007014773, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.5124209768583101, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.6021078092056223, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

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
        new MyJVMTest_11109().test_cp_unalndst(a, b, c, d);
    }
}
