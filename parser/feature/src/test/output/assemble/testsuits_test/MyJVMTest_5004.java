public class MyJVMTest_5004 {

    static float[] a0 = { Float.NaN, 0f, 0.12283009f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, 0f };

    static float[] a1 = { Float.NaN, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    float[] test_unrl_divi(float[] a0, float[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = a1[i + 0] / 1.f;
            a0[i + 1] = a1[i + 1] / 2.f;
            a0[i + 2] = a1[i + 2] / 3.f;
            a0[i + 3] = a1[i + 3] / 4.f;
        }
        for (; i < a0.length; i++) {
            a0[i] = a1[i] / (float) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5004().test_unrl_divi(a0, a1);
    }
}
