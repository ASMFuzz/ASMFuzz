public class MyJVMTest_1780 {

    static int[] a = { 4, -237513154, 0, 0, 7, 288616438, 5, 8, 0, 2 };

    static float[] b = { Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, 0f, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_ci_unaln(int[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1780().test_ci_unaln(a, b);
    }
}
