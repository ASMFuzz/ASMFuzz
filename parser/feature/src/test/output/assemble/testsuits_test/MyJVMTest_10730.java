public class MyJVMTest_10730 {

    static short[] a = { -32768, 23376, -32768, 32767, 32767, -878, -24351, -32768, 15666, 32767 };

    static short[] b = { 32767, -32768, 32767, 29320, 32767, -21321, 1765, 0, 32767, 23253 };

    static long[] c = { 0, -9223372036854775808L, 0, 5523267628936122927L, -7093380426452362976L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -8933876288498089972L, 2237351119253213054L };

    static long[] d = { -6478899804787753778L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 0, -3613328127733965120L, 0, 9223372036854775807L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10730().test_cp_unalndst(a, b, c, d);
    }
}
