public class MyJVMTest_12292 {

    static int[] a = { 7, 0, 3, 3, 560824287, -366075887, 1277106003, 0, 0, 9 };

    static int[] b = { 9, 5, 6, 2, 9, 888540533, 6, 5, 1624298157, 0 };

    static long[] c = { -9223372036854775808L, -4226506559774716984L, 9206412992162519910L, 9223372036854775807L, 3680863816473392920L, -9223372036854775808L, 0, -9223372036854775808L, 8549473139989284719L, 9223372036854775807L };

    static long[] d = { -7687166430424878837L, -9223372036854775808L, 0, 0, 0, 0, -7497601500067892646L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12292().test_cp_unalndst(a, b, c, d);
    }
}
