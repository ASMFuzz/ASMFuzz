public class MyJVMTest_3203 {

    static float[] a = { Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.POSITIVE_INFINITY, 0.8555287f, 0f, Float.NEGATIVE_INFINITY, 0.09926218f, Float.MIN_VALUE, 0f };

    float[] test_ci_neg(float[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3203().test_ci_neg(a);
    }
}
