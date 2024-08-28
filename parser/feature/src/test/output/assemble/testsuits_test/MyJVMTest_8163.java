public class MyJVMTest_8163 {

    static float[] a0 = { 0.5066018f, 0f, 0.12665904f, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY };

    static float[] a1 = { Float.POSITIVE_INFINITY, 0.82862514f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.39665836f, 0f };

    float[] test_divi(float[] a0, float[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] / (float) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8163().test_divi(a0, a1);
    }
}
