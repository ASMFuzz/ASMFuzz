public class MyJVMTest_6682 {

    static float[] a = { 0f, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.504728f, Float.MIN_VALUE, Float.MIN_VALUE };

    static float[] b = { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    float[] prodReductionInit(float[] a, float[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6682().prodReductionInit(a, b);
    }
}
