public class MyJVMTest_3921 {

    static float[] a0 = { Float.NEGATIVE_INFINITY, 0.93470186f, Float.MAX_VALUE, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.MIN_VALUE };

    float[] test_unrl_init(float[] a0) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = 0.f;
            a0[i + 1] = 1.f;
            a0[i + 2] = 2.f;
            a0[i + 3] = 3.f;
        }
        for (; i < a0.length; i++) {
            a0[i] = (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3921().test_unrl_init(a0);
    }
}
