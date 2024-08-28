public class MyJVMTest_16600 {

    static int[] a = { 9, 2, 3, 1726619976, 0, 8, 1999309839, 1690134888, 981543069, 3 };

    static int[] b = { 6, 7, -654498787, 2, 4, 1, 0, 599938701, 370271595, 9 };

    static long[] c = { -8363249825162423065L, -9223372036854775808L, 9223372036854775807L, -6664263248570692959L, 9223372036854775807L, 0, 0, 9223372036854775807L, -2428752197175267411L, 0 };

    static long[] d = { 600990892881422073L, 9223372036854775807L, -1827517419729116714L, 9223372036854775807L, -9223372036854775808L, 0, 7618941838270246625L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16600().test_cp_unalnsrc(a, b, c, d);
    }
}
