public class MyJVMTest_7386 {

    static int[] a = { 2, 1817470403, -1441823182, -2044021453, 0, 4, 7, 1740778811, 0, 935972218 };

    static long[] b = { 0, -9223372036854775808L, 3529312247256431226L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 7706665328019935141L, 9223372036854775807L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_ci_unaln(int[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7386().test_ci_unaln(a, b);
    }
}
