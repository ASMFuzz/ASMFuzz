public class MyJVMTest_637 {

    static short[] a = { 32767, 0, 0, 32767, 32767, 32767, 32767, 32767, -32158, -32768 };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 6493526970774514943L, 6043441896529847825L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_637().test_ci_aln(a, b);
    }
}
