public class MyJVMTest_16857 {

    static float[] a0 = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.8916889f, 0f };

    static float[] a1 = { 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.MIN_VALUE };

    float[] test_unrl_addi(float[] a0, float[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = a1[i + 0] + 0.f;
            a0[i + 1] = a1[i + 1] + 1.f;
            a0[i + 2] = a1[i + 2] + 2.f;
            a0[i + 3] = a1[i + 3] + 3.f;
        }
        for (; i < a0.length; i++) {
            a0[i] = a1[i] + (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16857().test_unrl_addi(a0, a1);
    }
}
