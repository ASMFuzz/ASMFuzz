public class MyJVMTest_12412 {

    static short[] a = { 17796, 32767, 32767, -32768, 32767, 0, -23691, -21376, -32768, -23858 };

    static float[] b = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.4832458f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_ci_unaln(short[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12412().test_ci_unaln(a, b);
    }
}
