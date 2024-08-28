public class MyJVMTest_2524 {

    static long[] a = { 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 0, 2089551981884115523L, 0, 0, 9223372036854775807L, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -4607899907731969688L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2524().test_cp_unalndst(a, b);
    }
}
