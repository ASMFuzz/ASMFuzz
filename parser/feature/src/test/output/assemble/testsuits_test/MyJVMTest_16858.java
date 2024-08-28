public class MyJVMTest_16858 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.15430236f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.7608831f, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MAX_VALUE, 0.471658f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.9582209f, 0.04999745f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.021182656f, Float.MAX_VALUE };

    float[] test_cp_neg(float[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16858().test_cp_neg(a, b);
    }
}
