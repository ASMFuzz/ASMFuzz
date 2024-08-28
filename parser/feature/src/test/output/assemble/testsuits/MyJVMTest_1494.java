public class MyJVMTest_1494 {

    static short[] a = { -32768, 11787, 32767, 32767, 0, -32768, 12777, 13422, -32768, -32768 };

    static short[] b = { 0, 32767, 31835, -32768, -32768, 32767, 32767, -32768, -10658, -32768 };

    static float[] c = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.84100556f, 0.13827467f, Float.MAX_VALUE };

    static float[] d = { Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0f, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE };

    short[] test_cp_oppos(short[] a, short[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1494().test_cp_oppos(a, b, c, d);
    }
}
