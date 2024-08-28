public class MyJVMTest_7330 {

    static float[] a0 = { Float.POSITIVE_INFINITY, 0.7456153f, 0.898565f, Float.MAX_VALUE, 0.4845209f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0.46288866f };

    static float[] a1 = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0.12224591f, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

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
        new MyJVMTest_7330().test_unrl_addi(a0, a1);
    }
}
