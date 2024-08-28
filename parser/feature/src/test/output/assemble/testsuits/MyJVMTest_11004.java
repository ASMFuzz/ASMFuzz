public class MyJVMTest_11004 {

    static int[] a = { 8, 1, 5, 0, 3, 0, 2061347344, 633741732, 0, 1569634482 };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NaN };

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
        new MyJVMTest_11004().test_ci_unaln(a, b);
    }
}
