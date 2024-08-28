public class MyJVMTest_16787 {

    static short[] a = { 32585, 32767, 32767, -32768, 23789, 0, 0, -32768, 32767, 0 };

    static short[] b = { 0, 32767, 32767, 32767, 0, 32767, 32767, 0, -32768, 0 };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static float[] d = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, 0.8785034f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.2768126f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16787().test_cp_alnsrc(a, b, c, d);
    }
}
