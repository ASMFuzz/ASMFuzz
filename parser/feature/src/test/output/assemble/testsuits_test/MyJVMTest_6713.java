public class MyJVMTest_6713 {

    static int[] a = { 4, 4, 0, 0, 6, 0, 6, 0, 3, 1 };

    static int[] b = { -1536773543, 1, -753250808, 4, 0, 0, 1320586186, 1405923942, 0, 8 };

    static double[] c = { 0.5102254766396015, 0.6798340473489028, 0.14321926509423755, Double.MIN_VALUE, 0.36487623344005826, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] d = { 0.8601713802812553, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6713().test_cp_unalnsrc(a, b, c, d);
    }
}
