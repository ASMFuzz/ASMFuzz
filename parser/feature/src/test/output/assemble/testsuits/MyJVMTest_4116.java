public class MyJVMTest_4116 {

    static float[] a = { Float.MIN_VALUE, 0f, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, 0f, 0.6671765f, Float.MIN_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.NaN, 0f, 0f, Float.NaN, Float.POSITIVE_INFINITY, 0.7444944f, 0.23453432f, Float.MIN_VALUE, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    float[] test_cp_unalnsrc(float[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4116().test_cp_unalnsrc(a, b);
    }
}
