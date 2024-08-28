public class MyJVMTest_3679 {

    static int[] a = { 8, 4, 0, -1741365578, 9, 0, 8, 2, 2, 0 };

    static long[] b = { -2118182740013096662L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -5699066632252830522L, 0 };

    static int c = 0;

    static long d = 4007524391075894959L;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, long[] b, int c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3679().test_vi_aln(a, b, c, d);
    }
}
