public class MyJVMTest_16357 {

    static short[] a = { -32768, 32767, 1984, -32768, 32767, -32768, 32767, -27142, 0, 0 };

    static float[] b = { 0.16071683f, 0f, Float.MAX_VALUE, Float.MAX_VALUE, 0.9180815f, 0.57500744f, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN };

    static short c = 0;

    static float d = 0.97741437f;

    short[] test_vi_oppos(short[] a, float[] b, short c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16357().test_vi_oppos(a, b, c, d);
    }
}
