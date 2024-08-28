public class MyJVMTest_6740 {

    static long[] a = { 0, -9223372036854775808L, 9223372036854775807L, 3704048445895218274L, 9223372036854775807L, -3475773552901825779L, 9223372036854775807L, 3130556876613975471L, 9223372036854775807L, 0 };

    static long[] b = { -9223372036854775808L, -3890934461768974436L, 0, 7824819716903490717L, 2106960197963354937L, 0, -9223372036854775808L, -9223372036854775808L, -8258781910881513030L, -5934627498808016903L };

    static long c = -9223372036854775808L;

    static long d = 0;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_2vi_unaln(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6740().test_2vi_unaln(a, b, c, d);
    }
}
