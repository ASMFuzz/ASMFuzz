public class MyJVMTest_10518 {

    static short[] a = { 32767, 7414, 32767, 32767, 0, -32768, 32767, -17221, -32768, 20959 };

    static float[] b = { 0.06968349f, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.7848188f, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10518().test_ci_aln(a, b);
    }
}
