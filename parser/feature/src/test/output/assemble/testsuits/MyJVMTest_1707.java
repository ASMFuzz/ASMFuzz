public class MyJVMTest_1707 {

    static float[] a = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.91918164f, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE };

    static int OFFSET = 3;

    float[] test_ci_off(float[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1707().test_ci_off(a);
    }
}
