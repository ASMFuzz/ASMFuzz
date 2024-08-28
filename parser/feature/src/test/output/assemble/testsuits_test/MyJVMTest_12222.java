public class MyJVMTest_12222 {

    static short[] a = { 0, -4821, 0, 0, 15784, 0, -9294, -22633, -32768, -32768 };

    static float[] b = { 0f, 0.36577177f, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, Float.NaN, 0f, Float.POSITIVE_INFINITY, 0.5209736f };

    static short c = 26650;

    static float d = Float.NEGATIVE_INFINITY;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, float[] b, short c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12222().test_vi_unaln(a, b, c, d);
    }
}
