public class MyJVMTest_2922 {

    static short[] a = { 0, -754, 0, 32767, 26140, -30650, 32767, 32767, -32768, -20017 };

    static float[] b = { 0.5871096f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.6332042f, Float.MAX_VALUE, 0.807204f, Float.MIN_VALUE };

    static short c = 0;

    static float d = Float.POSITIVE_INFINITY;

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
        new MyJVMTest_2922().test_vi_unaln(a, b, c, d);
    }
}
