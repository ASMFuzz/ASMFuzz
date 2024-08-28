public class MyJVMTest_16178 {

    static float[] a = { Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.56715894f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NaN };

    static float[] b = { Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MAX_VALUE, 0f };

    float[] prodReductionInit(float[] a, float[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16178().prodReductionInit(a, b);
    }
}
