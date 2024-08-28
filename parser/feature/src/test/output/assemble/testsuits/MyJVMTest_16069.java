public class MyJVMTest_16069 {

    static int[] a = { 3, -1011200270, 724755271, -1258512200, 0, 0, -1350808569, 2, 0, -877329417 };

    static int[] b = { 5, 1538303781, -1963525636, -232604439, 0, 6, 3, 8, 6, 0 };

    static float[] c = { 0f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.NaN, 0.97241855f, Float.POSITIVE_INFINITY };

    static float[] d = { 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0f, 0.35323083f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f };

    int[] test_cp_oppos(int[] a, int[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16069().test_cp_oppos(a, b, c, d);
    }
}
