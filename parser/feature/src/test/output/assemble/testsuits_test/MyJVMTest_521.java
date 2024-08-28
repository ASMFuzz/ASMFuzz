public class MyJVMTest_521 {

    static float[] a = { Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    static float b = Float.NEGATIVE_INFINITY;

    static int OFFSET = 3;

    float[] test_vi_off(float[] a, float b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_521().test_vi_off(a, b);
    }
}
