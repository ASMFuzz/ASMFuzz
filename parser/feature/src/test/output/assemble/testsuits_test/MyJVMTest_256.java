public class MyJVMTest_256 {

    static long[] a = { 9223372036854775807L, 0, 0, 0, 0, 0, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] b = { -6114471138695449455L, 9223372036854775807L, -9223372036854775808L, 4785761687178153635L, -9223372036854775808L, -9223372036854775808L, -4579150778064771202L, 0, -9223372036854775808L, -2738529201482498251L };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_256().test_cp_alndst(a, b);
    }
}
