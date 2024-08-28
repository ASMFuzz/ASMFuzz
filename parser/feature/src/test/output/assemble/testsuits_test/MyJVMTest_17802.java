public class MyJVMTest_17802 {

    static int[] a = { -539859259, 3, 2, -348893225, 0, 8, 3, 0, 0, 0 };

    static float[] b = { 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.8277877f, 0.15639627f };

    int[] test_ci(int[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17802().test_ci(a, b);
    }
}
