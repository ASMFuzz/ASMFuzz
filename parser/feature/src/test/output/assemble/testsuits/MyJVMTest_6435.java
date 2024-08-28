public class MyJVMTest_6435 {

    static long[] a = { -9223372036854775808L, 3328908109800322328L, 0, -9223372036854775808L, 0, 0, 0, -8239407318577401122L, -9223372036854775808L, -9223372036854775808L };

    static long[] b = { -6372620108704348092L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 0 };

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
        new MyJVMTest_6435().test_2ci_unaln(a, b);
    }
}
