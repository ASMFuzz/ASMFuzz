public class MyJVMTest_3020 {

    static int[] a = { -855751128, 9, 5, 8, 9, 1, 8, -986313186, 1, 0 };

    static long[] b = { -9223372036854775808L, 0, 0, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 5941354744909039701L, 0, 5828961392228259140L };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3020().test_ci_aln(a, b);
    }
}
