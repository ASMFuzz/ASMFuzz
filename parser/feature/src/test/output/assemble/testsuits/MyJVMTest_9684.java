public class MyJVMTest_9684 {

    static float[] a = { Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.87333304f, Float.POSITIVE_INFINITY, Float.NaN, Float.MAX_VALUE };

    static float b = Float.POSITIVE_INFINITY;

    static int OFFSET = 3;

    float[] test_vi_off(float[] a, float b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9684().test_vi_off(a, b);
    }
}
