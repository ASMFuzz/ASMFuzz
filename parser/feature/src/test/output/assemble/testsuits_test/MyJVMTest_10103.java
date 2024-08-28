public class MyJVMTest_10103 {

    static int[] a = { 5, 4, 360027763, -151985288, 0, 3, 9, 0, 9, 6 };

    static float[] b = { 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0f, 0f, 0.7718424f };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10103().test_ci_aln(a, b);
    }
}
