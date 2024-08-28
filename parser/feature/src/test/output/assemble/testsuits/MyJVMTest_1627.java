public class MyJVMTest_1627 {

    static short[] a = { 0, -27378, -32483, 0, 32767, -32768, 0, 9422, -14741, -32768 };

    static long[] b = { -2245244805507569744L, -7044542651327483708L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 6245229521261587043L, -3246577395693533778L, -9223372036854775808L, -9223372036854775808L };

    static short c = 32767;

    static long d = -9223372036854775808L;

    short[] test_vi_neg(short[] a, long[] b, short c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1627().test_vi_neg(a, b, c, d);
    }
}
