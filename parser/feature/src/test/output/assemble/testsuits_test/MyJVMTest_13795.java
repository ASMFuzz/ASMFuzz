public class MyJVMTest_13795 {

    static int[] a = { 6, 0, -612953146, 1, 6, -1147618502, 0, 0, 694685271, 1850515004 };

    static float[] b = { 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NaN, 0.3618362f };

    int[] test_ci_neg(int[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13795().test_ci_neg(a, b);
    }
}
