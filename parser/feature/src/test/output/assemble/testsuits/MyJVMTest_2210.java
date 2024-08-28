public class MyJVMTest_2210 {

    static float[] a = { 0.7597783f, 0f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY };

    float[] test_ci(float[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2210().test_ci(a);
    }
}
