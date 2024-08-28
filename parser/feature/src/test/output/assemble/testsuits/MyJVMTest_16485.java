public class MyJVMTest_16485 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -1769395852249016088L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, 0, -1434737017504810685L, 9223372036854775807L, 0, -9223372036854775808L, -4958056626424916370L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    long[] test_2ci_aln(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16485().test_2ci_aln(a, b);
    }
}
