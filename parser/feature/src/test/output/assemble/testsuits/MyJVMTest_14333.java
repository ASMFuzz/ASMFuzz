public class MyJVMTest_14333 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, 0f, 0.41421515f, Float.NEGATIVE_INFINITY, 0f, Float.NaN, 0f, Float.POSITIVE_INFINITY };

    float[] test_ci_oppos(float[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14333().test_ci_oppos(a);
    }
}
