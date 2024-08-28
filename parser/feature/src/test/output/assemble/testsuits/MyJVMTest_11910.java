public class MyJVMTest_11910 {

    static float[] a = { 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0.32081002f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float[] b = { 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, 0f, Float.MAX_VALUE, 0f, Float.NaN, Float.NEGATIVE_INFINITY };

    float[] test_cp_oppos(float[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11910().test_cp_oppos(a, b);
    }
}
