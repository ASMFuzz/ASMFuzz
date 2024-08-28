public class MyJVMTest_2629 {

    static float[] a = { Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.787405f, 0f, 0.0069410205f, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY };

    float[] test_cp_oppos(float[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2629().test_cp_oppos(a, b);
    }
}
