public class MyJVMTest_9141 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.67432934f, Float.MAX_VALUE, 0.41269642f, 0.0846166f, Float.POSITIVE_INFINITY, 0.85823977f, 0f, 0f };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NaN, 0.31773776f, Float.NaN };

    static int k = 0;

    int test_cp_inv(float[] a, float[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9141().test_cp_inv(a, b, k);
    }
}
