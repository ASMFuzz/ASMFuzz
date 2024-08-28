public class MyJVMTest_11795 {

    static long[] a = { -2137785289624244979L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 8507085201604046448L, 8172511771453617808L, 0, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -687218547008339471L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 7718193411110036567L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11795().test_cp_unalndst(a, b);
    }
}
