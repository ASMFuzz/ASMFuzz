public class MyJVMTest_17030 {

    static short[] a = { -19622, 0, 32767, 0, 32767, -8190, -28217, 17663, 32767, 32767 };

    static short[] b = { -32768, -32768, 29789, -12764, 32767, -32768, -32768, 0, -9447, -32768 };

    static float[] c = { 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float[] d = { Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, 0.00758785f };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17030().test_cp_unalnsrc(a, b, c, d);
    }
}
