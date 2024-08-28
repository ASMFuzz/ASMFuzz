public class MyJVMTest_261 {

    static float[] a = { Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float b = 0f;

    float[] test_vi_neg(float[] a, float b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_261().test_vi_neg(a, b);
    }
}
