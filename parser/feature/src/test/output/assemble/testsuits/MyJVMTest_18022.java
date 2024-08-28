public class MyJVMTest_18022 {

    static short[] a = { 32767, 32767, 32767, 32767, 32767, 0, -32768, -32768, 0, 21955 };

    static short[] b = { 0, -19875, -32768, 32767, 14908, 0, 32767, 10595, 32767, -32768 };

    static float[] c = { Float.MIN_VALUE, 0.9175476f, Float.MIN_VALUE, 0.027669907f, 0.5594172f, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE };

    static float[] d = { Float.POSITIVE_INFINITY, 0.2189874f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, 0.06956309f, Float.POSITIVE_INFINITY };

    short[] test_cp_neg(short[] a, short[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18022().test_cp_neg(a, b, c, d);
    }
}
