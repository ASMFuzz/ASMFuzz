public class MyJVMTest_5482 {

    static short[] a = { 0, 1503, 32767, -32768, -32768, 0, -32768, 9959, 27326, -32768 };

    static long[] b = { 0, -9223372036854775808L, 9223372036854775807L, 0, -2741685622339856025L, -9223372036854775808L, 0, -8309137530016135058L, -1055628228216473558L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_ci_unaln(short[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5482().test_ci_unaln(a, b);
    }
}
