public class MyJVMTest_6973 {

    static long[] a = { 1700427764350796731L, 0, 9223372036854775807L, 9223372036854775807L, 1423184659774103104L, -9223372036854775808L, 0, -9223372036854775808L, 0, 9223372036854775807L };

    static long[] b = { -1522508328717552143L, -9223372036854775808L, -982232547769649021L, 9223372036854775807L, 948417158430021142L, -9223372036854775808L, 5857153086238756111L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    long[] test_2ci_aln(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6973().test_2ci_aln(a, b);
    }
}
