public class MyJVMTest_154 {

    static float[] a = { Float.NaN, Float.NaN, 0.6889155f, Float.NaN, Float.NEGATIVE_INFINITY, 0.10781479f, 0f, 0.13746303f, 0.94812405f, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, 0.4279834f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    float[] test_2ci_oppos(float[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_154().test_2ci_oppos(a, b);
    }
}
