public class MyJVMTest_2986 {

    static int[] a = { -1968731864, 9, 2, 2, 9, 5, 0, 0, 1060299885, -310565017 };

    static int[] b = { 5, 0, 0, 8, 0, 0, 4, -790036298, 9, 0 };

    static long[] c = { -3807913654882328456L, -9223372036854775808L, 0, 9223372036854775807L, -2272405836491717054L, -9223372036854775808L, 6095688014884830233L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] d = { 2610625818511280338L, 9223372036854775807L, 9223372036854775807L, 0, -6803182263139953530L, 2385021536599700112L, 0, 0, 0, -7890261973077120097L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2986().test_cp_unalndst(a, b, c, d);
    }
}
