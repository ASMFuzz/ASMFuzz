public class MyJVMTest_12326 {

    static int[] a = { 2, 0, 0, 6, 1, 0, 1284082925, 0, 4, 0 };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -7457663970487895280L, -4791403865814612843L, 0, -9223372036854775808L, -4910287781453214700L, -9223372036854775808L, 0 };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12326().test_ci_aln(a, b);
    }
}
