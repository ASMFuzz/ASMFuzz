public class MyJVMTest_922 {

    static int[] a = { 0, 6, 633497523, 9, 812320877, 0, 4, 1934338855, 9, -609218053 };

    static float[] b = { Float.MAX_VALUE, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_922().test_ci_aln(a, b);
    }
}
