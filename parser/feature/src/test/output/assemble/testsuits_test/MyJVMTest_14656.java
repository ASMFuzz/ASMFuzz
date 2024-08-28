public class MyJVMTest_14656 {

    static byte[] a = { -34, -83, -42, -61, -42, -86, 2, -102, 111, 13 };

    static byte[] b = { 108, -97, -96, 59, 23, 55, 10, -101, 65, 3 };

    static long[] c = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, 0, 0, 0, 0 };

    static long[] d = { 7718473473127786596L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14656().test_cp_alndst(a, b, c, d);
    }
}
