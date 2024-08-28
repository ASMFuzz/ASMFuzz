public class MyJVMTest_11463 {

    static float[] a = { 0.4788373f, 0f, Float.NEGATIVE_INFINITY, 0.085098445f, 0.34914565f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    float[] test_ci(float[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11463().test_ci(a);
    }
}
