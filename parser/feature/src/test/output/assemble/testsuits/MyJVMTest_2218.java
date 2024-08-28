public class MyJVMTest_2218 {

    static float[] a = { 0.42103308f, 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f };

    static float b = 0.58780855f;

    static int k = 0;

    int test_vi_inv(float[] a, float b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2218().test_vi_inv(a, b, k);
    }
}
