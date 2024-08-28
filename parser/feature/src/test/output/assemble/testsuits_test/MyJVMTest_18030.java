public class MyJVMTest_18030 {

    static int[] a = { 0, 4, -1433213273, 1746564564, -42152847, 3, 0, 3, -1721376461, 8 };

    static int[] b = { 1811081908, 9, -1910306691, 9, 0, 1139156458, 287323959, 0, 0, 4 };

    static double[] c = { Double.MAX_VALUE, 0.03173948815249006, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE };

    static double[] d = { Double.NEGATIVE_INFINITY, 0.703476782647921, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18030().test_cp_alndst(a, b, c, d);
    }
}
