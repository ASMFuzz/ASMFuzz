public class MyJVMTest_4415 {

    static int[] a = { 0, 2, 6, 1, 2, 8, 2, 6, 1208313653, 1 };

    static float[] b = { Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.950242f, Float.POSITIVE_INFINITY };

    int[] test_ci_neg(int[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4415().test_ci_neg(a, b);
    }
}
