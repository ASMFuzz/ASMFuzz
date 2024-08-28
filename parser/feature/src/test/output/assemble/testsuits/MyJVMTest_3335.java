public class MyJVMTest_3335 {

    static float[] a = { Float.MAX_VALUE, 0.9651314f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0f, 0.42624635f, Float.POSITIVE_INFINITY, Float.NaN };

    static float[] b = { Float.NaN, Float.NaN, 0f, 0f, Float.MIN_VALUE, 0f, 0.107765496f, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE };

    static int OFFSET = 3;

    float[] test_cp_off(float[] a, float[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3335().test_cp_off(a, b);
    }
}
