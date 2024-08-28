public class MyJVMTest_13267 {

    static float[] a0 = { Float.NaN, Float.MIN_VALUE, 0.36079568f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, 0.9249801f, 0.07181072f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

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
        new MyJVMTest_13267().test_unrl_init(a0);
    }
}
