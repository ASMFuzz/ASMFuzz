public class MyJVMTest_5928 {

    static long[] a = { 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L };

    static long[] b = { 9223372036854775807L, 0, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 0, 9223372036854775807L, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5928().test_cp_unalnsrc(a, b);
    }
}
