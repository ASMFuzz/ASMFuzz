public class MyJVMTest_16673 {

    static byte[] a = { 13, -110, 15, 107, -72, -75, -2, -48, 88, -42 };

    static byte[] b = { 47, -60, 101, 106, -5, -108, -44, 13, -83, -60 };

    static long[] c = { 9223372036854775807L, -194477021477532456L, 8541373563618797138L, 0, 9223372036854775807L, 0, 9223372036854775807L, 3475760084991267322L, 6618997693736737586L, 0 };

    static long[] d = { 0, 0, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 0, 1714228561470621641L, -9223372036854775808L, -5003723870862641821L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16673().test_cp_unalndst(a, b, c, d);
    }
}
