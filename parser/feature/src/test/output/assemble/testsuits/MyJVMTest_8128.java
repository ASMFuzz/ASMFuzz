public class MyJVMTest_8128 {

    static int[] a = { -1331346803, 5, 4, 8, 0, -2088028412, 9, 0, 7, -701407260 };

    static int[] b = { 366786996, 336874014, 9, 1409447217, 8, 849842197, 9, 0, 2, 0 };

    static float[] c = { 0.27999932f, Float.NaN, 0f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f };

    static float[] d = { Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, 0.4724322f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8128().test_cp_alnsrc(a, b, c, d);
    }
}
