public class MyJVMTest_9412 {

    static float[] a = { 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0.5249576f, Float.NaN, 0f, Float.NEGATIVE_INFINITY, 0.42240715f, 0f };

    static float b = Float.NEGATIVE_INFINITY;

    float[] test_vi_neg(float[] a, float b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9412().test_vi_neg(a, b);
    }
}
