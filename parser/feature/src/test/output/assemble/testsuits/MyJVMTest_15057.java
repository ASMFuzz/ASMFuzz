public class MyJVMTest_15057 {

    static byte[] a = { 64, -96, 5, -27, -51, -65, -20, -36, -3, -116 };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 4328992056214523259L, -271300594253442078L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static byte c = 0;

    static long d = 9223372036854775807L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15057().test_vi_unaln(a, b, c, d);
    }
}
