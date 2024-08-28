public class MyJVMTest_3100 {

    static short[] a = { 32767, -32768, 0, -32768, -32768, 0, 10357, -32768, -32768, -32768 };

    static float[] b = { Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, 0.16349632f, Float.MIN_VALUE, Float.MIN_VALUE, 0.86543196f, Float.MAX_VALUE };

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
        new MyJVMTest_3100().test_ci_unaln(a, b);
    }
}
