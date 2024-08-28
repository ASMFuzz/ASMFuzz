public class MyJVMTest_1314 {

    static short[] a = { -32768, 0, -32768, 32767, 53, 32767, -32768, 0, -10437, -1878 };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1314().test_ci_aln(a, b);
    }
}
