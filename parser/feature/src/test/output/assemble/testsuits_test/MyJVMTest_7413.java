public class MyJVMTest_7413 {

    static float[] a0 = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    float[] test_init(float[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (float) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7413().test_init(a0);
    }
}
