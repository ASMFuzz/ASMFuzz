public class MyJVMTest_17736 {

    static float[] a0 = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float[] a1 = { 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    float[] test_divi(float[] a0, float[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] / (float) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17736().test_divi(a0, a1);
    }
}
