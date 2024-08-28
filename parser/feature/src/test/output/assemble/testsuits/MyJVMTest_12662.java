public class MyJVMTest_12662 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0.6087601f, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.106886625f, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] b = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.8612674f };

    static int OFFSET = 3;

    float[] test_cp_off(float[] a, float[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12662().test_cp_off(a, b);
    }
}
