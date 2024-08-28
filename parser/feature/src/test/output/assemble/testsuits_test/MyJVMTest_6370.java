public class MyJVMTest_6370 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static float b = Float.MAX_VALUE;

    float[] test_vi(float[] a, float b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6370().test_vi(a, b);
    }
}
