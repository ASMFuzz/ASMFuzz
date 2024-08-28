public class MyJVMTest_11471 {

    static float[] a = { 0f, 0f, Float.NEGATIVE_INFINITY, 0.39828306f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static float b = Float.NaN;

    static int k = -924328962;

    int test_vi_inv(float[] a, float b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11471().test_vi_inv(a, b, k);
    }
}
