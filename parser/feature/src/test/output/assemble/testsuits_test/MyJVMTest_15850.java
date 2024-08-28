public class MyJVMTest_15850 {

    static float[] a = { 0.8269256f, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN };

    static float b = Float.NEGATIVE_INFINITY;

    float[] test_vi(float[] a, float b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15850().test_vi(a, b);
    }
}
