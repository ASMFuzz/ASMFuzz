public class MyJVMTest_16455 {

    static int[] a = { 0, 2, 0, 6, 1, 0, 150531694, 8, 6, 0 };

    static float[] b = { 0.594012f, 0.25800937f, 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN };

    static int c = 4;

    static float d = Float.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_vi_unaln(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16455().test_vi_unaln(a, b, c, d);
    }
}
