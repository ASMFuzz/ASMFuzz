public class MyJVMTest_7534 {

    static byte[] a = { 1, 120, -91, -32, 124, -96, 68, 89, 55, -35 };

    static long[] b = { 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -4133069911454510452L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7534().test_ci_unaln(a, b);
    }
}
