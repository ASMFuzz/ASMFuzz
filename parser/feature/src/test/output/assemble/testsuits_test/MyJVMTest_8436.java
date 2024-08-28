public class MyJVMTest_8436 {

    static short[] a = { 0, 515, 0, 32767, 32767, 32767, 0, 0, 32767, 32767 };

    static short[] b = { 32767, -32768, 32767, 32767, -14727, -32768, 0, -32768, 0, 32767 };

    static float[] c = { Float.MAX_VALUE, 0.043124676f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.73209435f, Float.MIN_VALUE, 0f };

    static float[] d = { Float.MIN_VALUE, Float.MAX_VALUE, 0.57686573f, Float.NEGATIVE_INFINITY, Float.NaN, 0.4756838f, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.POSITIVE_INFINITY };

    short[] test_cp_neg(short[] a, short[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8436().test_cp_neg(a, b, c, d);
    }
}
