public class MyJVMTest_7399 {

    static int[] a = { 0, 1, 934479197, 2, 955364139, 9, 0, 1577767869, 3, 0 };

    static int[] b = { 8, 7, 8, 0, 8, 1585329352, 0, 634466101, 0, -1686871160 };

    static float[] c = { Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0.7849562f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static float[] d = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0.63970447f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.86652404f, 0.27604997f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7399().test_cp_unalnsrc(a, b, c, d);
    }
}
