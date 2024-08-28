public class MyJVMTest_4929 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    float[] test_ci_oppos(float[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4929().test_ci_oppos(a);
    }
}
