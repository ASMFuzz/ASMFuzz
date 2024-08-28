public class MyJVMTest_15921 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, -3246236660511947153L, 0, 0, 9223372036854775807L, 0 };

    static long[] b = { 9223372036854775807L, 0, 9223372036854775807L, 2004359439638074436L, 0, 3676653295380792154L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_2ci_unaln(long[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15921().test_2ci_unaln(a, b);
    }
}
