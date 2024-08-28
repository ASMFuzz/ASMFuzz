public class MyJVMTest_11778 {

    static int[] a = { 0, 1, 1, 2112518725, 5, 1530942160, 1297809142, -617364980, 7, 8 };

    static int[] b = { 2, 5, 1, 40962663, 1409344915, 4, 8, 0, 1669225422, -1908278882 };

    static float[] c = { Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.56998515f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    static float[] d = { 0f, Float.MAX_VALUE, 0f, 0.7967457f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.48301667f };

    int[] test_cp_neg(int[] a, int[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11778().test_cp_neg(a, b, c, d);
    }
}
